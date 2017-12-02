(ns aoc.day1.prob1
  (:require [aoc.util :refer [read-input]]))

(def input
  (->> (read-input "day1/prob1")
       (map #(Character/getNumericValue %))))

(defn seq-sum [input]
  (->> (conj (vec input) (last input))
       (partition-by identity)
       (map #(drop 1 %))
       (flatten)
       (reduce +)))

(defn -main
  [& args]
  (println (seq-sum input)))
