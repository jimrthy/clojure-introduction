;;;; This probably won't require, because I'm not depending on
;;;; datomic in the project.clj.
(ns clj-tut.sample
  (:require [clojure.pprint :refer (pprint simple-dispatch)]
            [datomic.api :as d]))

;;; You have to install this and start it running manually
(def url "datomic:free://localhost:4334/test")

(d/create-database url)

;; Add some schema
(let [test [{:db/id (d/tempid :db.part/db)
             :db/ident :guest/name
             :db/valueType :db.type/string
             :db/cardinality :db.cardinality/one
             :db/doc "What is this Guest called?"
             :db.install/_attribute :db.part/db}]
      conn (d/connect url)]
  (d/transact conn test))

(let [add-guest-txn '[{:db/id #db/id[:db.part/user -1]
                       :guest/name "one"}]
      conn (d/connect url)
      eventual-result (d/transact conn add-guest-txn)]
  (println "transact returns a: " (class eventual-result))
  @eventual-result)

;; Getting that first entity ID when the transaction's
;; that simple
(let [add-guest-txn '[{:db/id 17592186045418
                       :guest/name "original"}
                      {:db/id #db/id[:db.part/user -1]
                       :guest/name "another"}
                      {:db/id #db/id[:db.part/user -2]
                       :guest/name "two"}
                      {:db/id #db/id[:db.part/user -3]
                       :guest/name "three"}]
      conn (d/connect url)]
  @(d/transact conn add-guest-txn))

;; So, what does that give us?
;; (I like the map-style query, even though most examples
;; seem to go with the vector-style.
;; According to the docs, this way may be slightly more
;; efficient, but I'm pretty sure it's only a matter of taste
;; once we start talking about anything like real-world
;; data loads where performance isn't just instant
(let [q '{:find [?e ?name]
          :where [[?e :guest/name ?name]]}]
  (d/q q (d/db (d/connect url))))

;;; That's really pretty boring.
;;; Add some more schema
;;; This may look complicated, but it's really
;;; about as boring and repetitive as this sort
;;; of thing can get.
;;; Note that this is really just another transaction,
;;; exactly like asserting any other fact (aka
;;; doing an upsert)
(let [test [{:db/id (d/tempid :db.part/db)
             :db/ident :guest/id
             :db/valueType :db.type/uuid
             :db/cardinality :db.cardinality/one
             :db/doc "How does a computer refer to this guest?"
             :db.install/_attribute :db.part/db}
            {:db/id (d/tempid :db.part/db)
             :db/ident :guest/mor
             :db/valueType :db.type/string
             :db/cardinality :db.cardinality/one
             :db/doc "Managed Object Reference ID"
             :db.install/_attribute :db.part/db}
            {:db/id (d/tempid :db.part/db)
             :db/ident :guest/launched
             :db/valueType :db.type/instant
             :db/cardinality :db.cardinality/one
             :db/doc "Maybe when we sent the launch request?"
             :db.install/_attribute :db.part/db}]
      conn (d/connect url)]
       (d/transact conn test))

;; I meant to set the UUID instead, but might as well rename it
;; again
(let [now (java.util.Date.)
      guest-launch-txn [{:db/id 17592186045418
                         :guest/launched now
                         :guest/mor "Something Constant"
                         :guest/name "Completely Arbitrary"}]
      conn (d/connect url)]
  @(d/transact conn guest-launch-txn))

;; What has that created?
;; Note that the ?attrib is just another int,
;; at least similar to another entity ID
(let [q '{:find [?e ?name ?attrib ?attrib-name ?value]
          :where [[?e :guest/name ?name]
                  [?e ?attrib ?value]
                  [?attrib :db/ident ?attrib-name]]}
      conn (d/connect url)]
  (d/q q (d/db conn)))

