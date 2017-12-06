(ns aoc.day6.prob1
  (:require [aoc.util :refer :all]
            [clojure.string :as str]))

(def input
  (->> (read-input "day6/prob1")
       (#(str/split % #"\s+"))
       (map #(Integer/parseInt %))
       (vec)))

(defn add-to-loc
  [m loc]
  (update-in m [loc] inc))

#_(add-to-loc [1 2 3] 1)

(defn redistribute
  [v pos blocks]
  (let [new-pos (mod (inc pos) (count v))
        new-v (add-to-loc v new-pos)
        new-blocks (dec blocks)]
    (if (zero? blocks)
      v
      (recur new-v new-pos new-blocks))))

#_(redistribute input 0 17)

(defn reallocate
  [v steps seen]
  (let [seen (assoc seen v true)
        blocks (apply max v)
        pos (.indexOf v blocks)
        new-v (assoc v pos 0)
        new-v (redistribute new-v pos blocks)]
    (if (contains? seen new-v)
      (inc steps)
      (recur new-v (inc steps) seen))))

#_(reallocate input 0 {})

(defn -main
  [& args]
  (println (reallocate input 0 {})))
