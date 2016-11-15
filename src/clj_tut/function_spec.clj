(ns clj-tut.function-spec
  (:require [clojure.spec :as s]))

(s/fdef ::foo :args (s/cat :n integer?))

(defn f [n]
  (* n 2))

(s/valid? ::foo f)
;; => false

(s/explain-data ::foo f)
;; => nil
