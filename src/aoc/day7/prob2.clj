(ns aoc.day7.prob2
  (:require [aoc.util :refer :all]
            [clojure.string :as str]
            [aoc.day7.prob1 :as prob1]))

(defn get-key
  [s]
  (let [[name, w] (str/split s #" ")]
    [name
     (->> (str/replace w #"[\(|\))]" "")
          (Integer/parseInt))]))

#_(get-key "abc (43)")

(defn get-pair
  [s]
  (let [[k v] (str/split s #" -> ")]
    [(get-key k)
     (if v (prob1/split-children v))]))

(def input
  (->> (read-input "day7/prob1")
       (str/split-lines)
       (map get-pair)))

#_(first input)

;; TODO: Write a clean solution :(
