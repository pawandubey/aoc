(ns aoc.day3.prob1
  (:require [aoc.util :refer :all]
            [clojure.math.numeric-tower :refer [expt]]))

(def input 289326)

(defn grid-dims
  [input]
  (Math/ceil (Math/sqrt input)))

#_(grid-dims input)

(defn port-pos
  [dim]
  (->> (if (odd? (int dim))
         [(/ dim 2) (/ dim 2)]
         [(/ dim 2) (/ (- dim 1) 2)])
       (map #(Math/floor %))))

(defn data-pos
  [num dim]
  (let [diff (- (expt dim 2) num)
        [row, col] [(- dim 1) (- dim 1)]
        row (if (> diff col)
              (- row (- diff col))
              row)
        col (max (- col diff) 0)]
    [row col]))


#_(port-pos 538)
#_(data-pos input (grid-dims input))

(defn steps
  [input]
  (let [dim (grid-dims input)
        ppos (port-pos dim)
        dpos (data-pos input dim)]
    (->> (map vector dpos ppos)
         (map #(- (first %) (last %)))
         (reduce +))))

(defn -main
  [& args]
  (println (steps input)))
