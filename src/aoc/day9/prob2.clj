(ns aoc.day9.prob2
  (:require [aoc.day9.prob1 :as prob1]
            [clojure.string :as str]))

(defn process-char
  [char score garbage]
  (condp = char
    \< (if-not garbage
         [score true]
         [(inc score) garbage])
    \> [score false]
    (if garbage
      [(inc score) garbage]
      [score garbage])))

#_(process-char \< 1 true)

(defn process-str
  [str score garbage]
  (let [[score garbage] (process-char (first str) score garbage)
        next-str (next str)]
    (if (seq next-str)
      (recur next-str score garbage)
      score)))

(defn total-score
  [input]
  (let [score 0
        garbage false]
    (->> input
         (#(str/replace % #"!!", ""))
         (#(str/replace % #"!.", ""))
         (#(process-str % score garbage)))))

#_(total-score prob1/input)

(defn -main
  [& args]
  (println (total-score prob1/input)))
