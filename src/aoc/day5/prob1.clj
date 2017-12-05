(ns aoc.day5.prob1
  (:require [aoc.util :refer :all]
            [clojure.string :as str]))

(def input
  (->> (read-input "day5/prob1")
       (str/split-lines)
       (map #(str/trim %))
       (map #(Integer/parseInt %))
       (vec)))

(defn move
  [v pos]
  (let [new-pos (+ pos (get v pos))
        new-vec (update-in v [pos] inc)]
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
