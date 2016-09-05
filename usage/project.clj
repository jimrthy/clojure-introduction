(defproject clj-tut "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [#_[org.clojure/clojure "1.9.0-alpha10"]
                 [org.clojure/clojure]
                 #_[cider-transitive-version "0.1.0-SNAPSHOT"]]
  :parent-project {:path "../cider-transitive-version/project.clj"
                   :inherit [:managed-dependencies]}
  :plugins [[lein-parent "0.3.0"]])
