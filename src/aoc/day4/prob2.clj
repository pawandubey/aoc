(ns aoc.day4.prob2
  (:require [aoc.util :refer :all]
            [clojure.string :as str]
            [aoc.day4.prob1 :as prob1]
            [clojure.math.combinatorics :as comb]))

(def input (read-input "day4/prob1"))

(defn valid-passphrase?
  [s]
  (->> s
       (#(str/split % #"\s+"))
       (map sort)
       (apply distinct?)))

(defn count-valid-passphrases
  [input]
  (->> (prob1/passphrases input)
       (filter valid-passphrase?)
       (count)))

(defn -main
  [& args]
  (println (count-valid-passphrases input)))
