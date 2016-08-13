;;;; Comments start with semi-colons.
;;;; There's a long-standing convention that there's hierarchical
;;;; Sort of structure to the number of semi-colons.
;;;; 4 mark comments that apply to the entire file

;;; 3 semicolons start a comment that applies to the
;;; next several lines.
;;; 2 semicolons mark comments that apply to the next line
;;; 1 semicolon is for a comment that explains the current line

;; Every clojure source file should start with a namespace declaration
(ns clj-tut.core) ; This gets complicated. Worry about it later.

;;;; Data types

;;; The basics work exactly the way you'd expect:

13
3.14159
2/5   ; Rationals are built in
"Strings are the same as in the host language (for now, for us, that's java"
;; Single character constants aren't really used very often
\x
\1
\;
\\
\space
\tab

;;; Pretty much everything can be used as a boolean.
;;; There are two false values
nil      ; Maybe like SQL NULL or javascript's undefined
false    ; Absolutely everything else is true

;;; You can create basic data literals very simply

;; Vectors are like arrays
[0 1 2 3 4]

;; Sets contain unique values
;; Don't try to declare literal sets with duplicates
#{1 2 3 4}

;; Hashmaps are like dictionaries.
;; They're heterogeneous
;; Commas are white-space: they can be convenient
;; for sepearating key/value pairs
{"key" "value",
 1 "one",
 :a "That's a keyword"}

;; Keywords are sort of like C enums.
;; They're great for when you want some sort of
;; meaningful name but don't care about its
;; value. (This really gets into a concept
;; or paradigm called symbolic computing,
;; which I don't know a lot about).
;; There are a few rules about which characters
;; you can use, but the main one is that they
;; start with a colon.

;; Data structures also nest
{:name "Something fancy and complicated",
 :nested-vector [1 2 :blah "foo"],
 [1 2] "vectors are values, so they can be keys",
 #{:so-can-sets} {:nested :map,
                  :abc [1 2 3]},}

;; Then there are symbols.
;; Which are kind of like keywords, but they are
;; usually "bound" to something meaningful.
;; When the reader runs across a symbol, it will
;; try to replace it with whatever value it's
;; bound to.
map  ; That's a function
*out*  ; STDOUT. The *earmuffs* are a flag that this is special
;;; More functions, with names that would be questionable in
;;; most languages
+  
assoc!
;; -> is a legal symbol, but you can't look at it by itself

;;; Sometimes you don't want the reader to do that symbol
;;; resolution. Like when the symbol hasn't actually been
;;; bound yet. Single quote means "just take the next thing
;;; and treat it as a data literal. Trust me: I know what
;;; I'm doing"
'{:find [?e ?a]
  :in [$ ?v]
  :where [[?e ?attr ?v]
          [?attr :db/ident ?a]]} ; this is a datomic query, BTW

;;; That brings us to the last major data type: the linked list:
'(1 2 3)  ; linked list of ints
'(Linked list of symbols)
'(We had to quote these because lists are special)
'(Lists are usually function calls)
'(The syntax is
      (operator arg1 arg2 argn))

;;; Functions

(+ 1 2 3)  ; 6
(* (+ 1 2) (- 8 4))  ; Nested functions get called first

;; Data structures are functions that will return the value
;; associated with a key:
([0 1 2] 1)
(#{'a :b "c" 3} "c")
({'a 1 :b 2 "c" 3 :d 4} "c")
({:a 1 :b 2 :c 3} :d)

;; Keywords are also functions that know how to look
;; themselves up, when it makes sense
(:a {:a 1 :b 2 :c 3})
(:a #{:a "b" 4})
(:d {:a 1 :b 2 :c 3})  ; Missing key? No big deal
(:d {:a 1 :b 2 :c 3} :missing)  ; You can also provide a default

:and :then :there :are :special :forms

"Every language has its building blocks.
Maybe you think of them as private reserved keywords.
Or just magic identifiers you don't try to override.
Until some new language comes along and breaks the rules.

class is the first one that comes to mind, from most
OO languages.
return is another.
++ used to be one in C, then C++ changed the rules drastically.

Lisp has a very special history in this area.

It really all started with a white paper that showed how to
convert this advanced mathematical notation into a Turing-complete
machine if you had 5 'special operators'. (For anyone who cares,
they were atom, eq, car, cdr, and cons. To make it usable,
McCarthy added quote, cond, lamdba, and label. People are still
arguing about the bare minimum you need for the basic architecture).

Whatever. Clojure's built on much richer machines than they had back
then. We've benefited from something like 60 years worth of lisp
ideas gaining acceptance in the mainstream. These days, pretty much
everyone agrees that ideas like automatic garbage collection, recursion,
and if statements (which all came from lisp) are probably pretty good
ideas. At least in general.

Clojure's 'special forms' are really quite a bit more powerful."

;; This *totally* isn't what you think it is.
;; There's a value (the keyword), and there's a thing called a
;; var. This binds those to the symbol `global` in the current
;; namespace.
;; For starters, it doesn't hurt to think of this as a global
;; variable. Keep in mind that it isn't necessarily as evil
;; as you'd generally expect. (Though you still mostly want
;; to avoid these)
(def global :this-isnt-really-global)

(if :anything
  (do
    (println "In lisp, there are two ways to handle if statements")
    '[they are both annoying]
    (str "In clojure, if one of your clauses takes multiple forms,
then you have to wrap them all in a do.
Which happens to be another special form"))
  (/ 1 0)  ; if this got eval'd, it'd throw an exception
)

(let [local [1 2 3]
      foo :bar
      baz "finally!"]
  (println "We " baz " reached " local " values.

def changes the namespace so that its first argument (a
symbol) is bound to the value returned by its second
argument.

let creates a new lexical scope where it binds symbols
to values. When execution reaches the end of the let,
that binding goes away.

For example: " foo))

(comment (println "This will fail:" foo))

;; 'a is magic that expands into:
(quote a)

;; The only time I've ever used this directly is to refer to private
;; members in other namespaces. There's an important point to it,
;; but I don't know what it is.
(comment (var abc))

(let [f (fn anonymous [param]
          (str "You just created an anonymous function and passed "
               param
               " into it as a parameter!\n
\tIsn't this exciting??!!"))]
  (f '(you might be surprised to know that you can do this recursively)))

;; TODO: This is an infinite sequence. I should show how they work.
;; Not for the sake of working out a cool problem that demonstrates
;; lazy evaluation.
;; Strictly for the purposes of demonstrating multiple arity and the
;; way it relates to the special form `fn`.
(comment (let [fibonacci
               (fn
                 ([] 1)
                 ([n] n)
                 ([m n]
                    ())
                 )]))

;;; loop is a prime example of the way clojure bends over backwards
;;; to work inside the host system.
;;; This should be a recursive function call. It would blow up
;;; the stack. So we pretend it's recursive. And, for all intents
;;; and values, it is. It just works with java's limitations.
;;; For a long time, this sort of thing was comforting to me.
;;; It seemed to make sense as an obvious for-each loop,
;;; or something along those lines.
;;; In general, you shouldn't be doing this. There are built-in
;;; functional macros (we'll get to those later) that handle
;;; this for the 90% case.
(loop [n 10]
  (if (< 0 n)
    (do
      (println n)
      (recur (dec n)))
    (println "Blast Off!")))

(try
  (println "I'm trying!")
  (throw (RuntimeException. "This sucks"))
  (catch RuntimeException ex
    (println "I'm here, inside this error handler"
             ex
             "I don't know what to do with that thing.
It smells")
    (throw ex))
  (finally
    (println "I'm cleaning up anyway")))

(println "Congratulations!!!
There are a few more, but the documentation gets sparse.

So that's the general idea about the basic things that
should get you started.")

;;; Macros



;;; Whitespace

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
