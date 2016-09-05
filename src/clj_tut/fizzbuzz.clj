(ns clj-tut.fizzbuzz
  (:require [clojure.repl :refer (pst)]))

;;;; A coworker was looking into idiomatic ways to do this
;;;; This was my approach, FWIW

;;;; Problem: write a program that prints out a bunch
;;;; of incrementing integers.
;;;; Unless the integer is evenly by 3, in which case
;;;; you print out fizz
;;;; Or the integer is evenly divisible by 5, in which case
;;;; you should print out buzz
;;;; If the number is evenly divisible by both 5 and 3,
;;;; print out fizzbuzz

;;;; Just to make life interesting: no division or modulus
;;;; allowed

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Baseline:
;;; Start with a function that returns the value to display

(defn distinguish
  [n next-3 next-5]
  {:pre [(>= next-3 n)
         (>= next-5 n)]}
  (cond
   (= n next-3 next-5) 'fizzbuzz
   (= n next-3) 'fizz
   (= n next-5) 'buzz
   :else n))

;; Use the REPL to eval these for unit tests
(comment (distinguish 1 3 5)
         (distinguish 2 3 5)
         (distinguish 3 3 5)
         (distinguish 5 3 5)  ; should fail preconditions
         (distinguish 5 6 5)
         (distinguish 15 15 5)  ; should also fail
         (distinguish 15 15 15))

(defn next-mod
  "Return the next even multiple of increment for testing n"
  [n next increment]
  {:pre [(> (+ next increment) n)]}
  ;; To do this properly, coping with bad
  ;; input, I should really do
  ;; this in a while loop.
  ;; reduce might also be a nice choice
  (if (> n next)
    (+ increment next)
    next))

(comment (next-mod 3 4 2)
         (next-mod 6 6 3)
         (next-mod 7 6 3)
         (next-mod 10 6 3))  ; Invalid inputs

(defn ++
  "Find the next member of the sequence"
  [{:keys [n next-3 next-5] :as current}]
  (let [n++ (inc n)
        next-3 (next-mod n++ next-3 3)
        next-5 (next-mod n++ next-5 5)
        display (distinguish n++ next-3 next-5)]
    {:n n++
     :next-3 next-3
     :next-5 next-5
     :display display}))

;; That doesn't work quite the way I was wanting,
;; but it does seem to be working.
;; Pay attention to the values these next calls return
(comment (++ {:n 3 :next-3 3 :next-5 5})
         (++ {:n 4 :next-3 6 :next-5 5})
         (++ {:n 5 :next-3 6 :next-5 5})
         (++ {:n 8 :next-3 9 :next-5 10})
         (++ {:n 9 :next-3 9 :next-5 10})
         (++ {:n 14 :next-3 15 :next-5 15})
         (++ {:n 15 :next-3 15 :next-5 15}))

(defn fizzbuzz*
  "Helper function that does the actual work
The default parameters should be more robust.
Should really set next-3 and next-5 to the appropriate
multiple that's >= n"
  [{:keys [n next-3 next-5]
    :or {n 0
         next-3 3
         next-5 5}}]
  (comment (println "realizing " n next-3 next-5 " based on " it))
  (let [it  {:n n
             :next-3 next-3
             :next-5 next-5}]
    (cons it (lazy-seq (fizzbuzz* (++ it))))))

(take 15 (fizzbuzz* {}))

(defn fizzbuzz
  []
  (map (fn [{:keys [n next-3 next-5]}]
         (distinguish n next-3 next-5))
       (fizzbuzz* {})))

;;; Now we have an infinitely lazy seq,
;;; which does what we wanted:
(comment (take 15 (fizzbuzz))
         (take 15 (drop 30 (fizzbuzz)))
         (take 15 (drop 1e6 (fizzbuzz))))

;;; But some core functionality can clean it up a bit
;;; TODO: move this back above fizzbuzz, just replacing
;;; the original
(defn fizzbuzz*
  "Helper function that does the actual work
The default parameters should be more robust.
Should really set next-3 and next-5 to the appropriate
multiple that's >= n"
  [{:keys [n next-3 next-5]
    :or {n 0
         next-3 3
         next-5 5}}]
  (comment (println "realizing " n next-3 next-5 " based on " it))
  (let [it  {:n n
             :next-3 next-3
             :next-5 next-5}]
    (iterate ++ it)))

(comment (take 15 (fizzbuzz))
         (take 15 (drop 30 (fizzbuzz)))
         (take 15 (drop 1e6 (fizzbuzz)))
         (take 15 (drop 1e12 (fizzbuzz)))
)
