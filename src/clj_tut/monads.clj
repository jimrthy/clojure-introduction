(ns frereth-common.monads
  "Really just for experimentation")

;; A monadic function
(defn half-double [n]
  [(/ n 2) (* 2 n)])

;; Another monadic function
(defn inc-int [n]
  [(+ 5 n) (+ 10 n)])

(defn check [n]
  (let [[half double] (half-double n)]
    (concat (inc-int half)
            (inc-int double))))

(defn do-both [n]
  (apply concat
         (map inc-int
              (half-double n))))

(defn m-bind [ns int-fn]
  (apply concat
         (map int-fn ns)))

;; And another monadic function
(defn do-both-1 [n]
  (m-bind (half-double n) inc-int))

;;; A monadic function is a function that accepts a
;;; value and returns a monadic value.
;;; For the sequence monad, a list of values (e.g.
;;; integers is a monadic value.

;;; A monadic function is a function that accepts a
;;; value and returns a monadic value.

;;; How do you convert an ordinary integer to a monadic
;;; value?
;;; Well, if the monadic value is represented as a list
;;; of integers, the list function works:
(def m-result list)
