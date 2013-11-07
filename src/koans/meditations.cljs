(ns koans.meditations)

(def meditations '(
  "We shall contemplate truth by testing reality, via equality"
  (= :__ true)

  "To understand reality, we must compare our expectations against reality"
  (= :__ (+ 1 1))

  "You can test equality of many things"
  (= (+ 3 4) 7 (+ 2 :__))

  "But you may not string yourself along"
  (= :__ (= 2 "2"))

  "Something is not equal to nothing"
  (= :__ (not (= 1 nil)))

  "Strings, and keywords, and symbols: oh my!"
  (= :__ (= "foo" :foo 'foo))

  "Make a keyword with your keyboard"
  (= :foo (keyword :__))

  "Symbolism is all around us"
  (= 'foo (symbol :__))

  "When things cannot be equal, they must be different"
  (not= :fill-in-the-blank :__)))

(defrecord Koan [description before after])

(defn nth-koan [n]
  (let [item (nth (partition 2 meditations) n)
        description (first item)
        [before after] (clojure.string/split (pr-str (last item)) #":__")]
    (Koan. description before after)))