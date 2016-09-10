(set-env!
 :resource-paths #{"src"}
 :dependencies '[[cider-transitive-version "0.1.0-SNAPSHOT"]])

(task-options!
 pom {:project 'clj-tut
      :version "0.1.0-SNAPSHOT"})
