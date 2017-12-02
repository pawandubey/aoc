(ns aoc.day2.prob2
  (:require [clojure.math.combinatorics :as comb]
            [aoc.day2.prob1]))

(def input aoc.day2.prob1/input)

(defn divisible-combs
  [row]
  (->> (comb/combinations row 2)
       (map (comp reverse sort))
       (filter (fn [[n d]] (= 0 (mod n d))))
       (flatten)))

(defn checksum2
  [input]
  (->> input
       (map #(divisible-combs %))
       (map (partial apply /))
       (reduce +)))

(defn -main
  [& args]
  (println (checksum2 input)))
