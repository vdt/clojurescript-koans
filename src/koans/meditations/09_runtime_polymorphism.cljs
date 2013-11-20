(ns koans.meditations.runtime-polymorphism)

(def koans '(
  "Some functions can be used in different ways - with no arguments"
  (= :__ (hello))

  "With one argument"
  (= :__ (hello "world"))

  "Or with many arguments"
  (= :__
     (hello "Peter" "Paul" "Mary"))

  #_(
  "Multimethods allow more complex dispatching"
  (= "Bambi eats veggies."
     (diet {:species "deer" :name "Bambi" :age 1 :eater :herbivore}))

  "Different methods are used depending on the dispatch function result"
  (= "Simba eats animals."
     (diet {:species "lion" :name "Simba" :age 1 :eater :carnivore}))

  "You may use a default method when no others match"
  (= "I don't know what Rich Hickey eats."
     (diet {:name "Rich Hickey"}))
  )
))

(def fns [
  "(defn hello
  ([] \"Hello World!\")
  ([a] (str \"Hello, you silly \" a \".\"))
  ([a & more] (str \"Hello to this group: \"
                   (apply str
                          (interpose \", \" (concat (list a) more)))
                   \"!\")))"
  #_'(defmulti diet (fn [x] (:eater x)))
  #_'(defmethod diet :herbivore [a] :__)
  #_'(defmethod diet :carnivore [a] :__)
  #_'(defmethod diet :default [a] :__)
])