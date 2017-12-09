(ns aoc.day7.prob1
  (:require [aoc.util :refer :all]
            [clojure.string :as str]
            [clojure.set :as set]))

(defn split-children
  [s]
  (str/split s #", "))

(defn get-key
  [s]
  (first (str/split s #" ")))

(defn get-pair
  [s]
  (let [[k v] (str/split s #" -> ")]
    [(get-key k)
     (if v (split-children v))]))

(def input
  (->> (read-input "day7/prob1")
       (str/split-lines)
       (map get-pair)))

(defn find-root
  "Root is the element on the LHS that doesn't appear on the RHS"
  [input]
  (let [h (into {} input)]
    (set/difference ((comp set keys) h) ((comp set flatten vals) h))))

(defn -main
  [& args]
  (println (first (find-root input))))
