(ns clj-tut.check)

(let [preliminary {:name ["original-name" "modified name"]
                   :screen/left [0 240]
                   :screen/top [0 400]
                   :screen/width [900 900]
                   :screen/height [600 600]}]
  (reduce (fn [acc [k delta]]
            (assoc acc k (second delta)))
          {}
          (filter (fn [[k v]]
                    (not= (first v) (second v)))
                  preliminary)))
{:screen/left 240, :name "modified name", :screen/top 400}

([:screen/top [0 400]] [:name ["original-name" "modified name"]] [:screen/left [0 240]])
