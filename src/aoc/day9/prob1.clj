(ns aoc.day9.prob1
  (:require [aoc.util :refer :all]
            [clojure.string :as str]))

(def input (read-input "day9/prob1"))

(defn process-char
  [char score level garbage]
  (condp = char
    \{ (if-not garbage
          [score (inc level) garbage]
          [score level garbage])
    \} (if-not garbage
          [(+ score level) (dec level) garbage]
          [score level garbage])
    \< (if-not garbage
          [score level true]
          [score level garbage])
    \> [score level false]
    [score level garbage]))

#_(process-char \} 1 1 false)

(defn process-str
  [str score level garbage]
  (let [[score level garbage] (process-char (first str) score level garbage)
        next-str (next str)]
    (if (seq next-str)
      (recur next-str score level garbage)
      score)))

#_(process-str "{{<a!>},{<a!>},{<a!>},{<ab>}}" 0 0 false)

(defn total-score
  [input]
  (let [score 0
        level 0
        garbage false]
    (->> input
         (#(str/replace % #"!!", ""))
         (#(str/replace % #"!.", ""))
         (#(process-str % score level garbage)))))

#_(total-score "{{{},{},{{}}}}")

(defn -main
  [& args]
  (println (total-score input)))
