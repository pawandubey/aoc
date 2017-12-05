(ns aoc.day5.prob2
  (:require [aoc.util :refer :all]
            [aoc.day5.prob1 :as prob1]))

(def input prob1/input)

(defn move
  [v pos]
  (let [new-pos (+ pos (get v pos))
        new-vec (if (< (get v pos) 3)
                  (update-in v [pos] inc)
                  (update-in v [pos] dec'))]
    [new-vec new-pos]))

(defn escape-maze
  [v pos steps]
  (let [[new-vec new-pos] (move v pos)]
    (if (< new-pos (count new-vec))
      (recur new-vec new-pos (+ steps 1))
      (+ steps 1))))

(defn count-steps
  [input]
  (escape-maze input 0 0))

(defn -main
  [& args]
  (println (count-steps input)))
