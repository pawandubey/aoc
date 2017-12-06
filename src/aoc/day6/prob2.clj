(ns aoc.day6.prob2
  (:require [aoc.util :refer :all]
            [clojure.string :as str]
            [aoc.day6.prob1 :as prob1]))

(def input prob1/input)

(defn cycle-point
  [v steps seen]
  (let [seen (assoc seen v true)
        blocks (apply max v)
        pos (.indexOf v blocks)
        new-v (assoc v pos 0)
        new-v (prob1/redistribute new-v pos blocks)]
    (if (contains? seen new-v)
      new-v
      (recur new-v (inc steps) seen))))

#_(cycle-point input 0 {})

(defn -main
  [& args]
  (println (prob1/reallocate (cycle-point input 0 {}) 0 {})))
