(ns aoc.day1.prob2
  (:require [aoc.util :refer [read-input]]))

(def input
  (->> (read-input "day1/prob1")
       (map #(Character/getNumericValue %))))

(defn zip
  [& colls]
  (partition (count colls) (apply interleave colls)))

(defn split-in-half
  [coll]
  (partition (/ (count coll) 2) coll))

(defn offset-sum
  [input]
  (let [split-input (split-in-half input)]
    (->> (zip (first split-input) (last split-input))
         (filter #(apply = %))
         (flatten)
         (reduce +))))

(defn -main
  [& args]
  (println (offset-sum input)))
