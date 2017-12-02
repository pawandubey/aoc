(ns aoc.day2.prob1
  (:require [aoc.util :refer [read-input]]
            [clojure.string :as str]))

(defn parse-int [x] (Integer/parseInt x))

(defn parse-list [x] (map parse-int x))

#_(and
   (= '(1 2 3) (parse-list (list "1" "2" "3")))
   (= '(123 541 2) (parse-list ["123" "541" "2"]))
   (= '((1 2) (3 4)) (map parse-list '(["1" "2"] ["3" "4"]))))

(def input
  (->> (read-input "day2/prob1")
       (str/split-lines)
       (map #(str/split % #"\s+"))
       (map parse-list)))

(defn checksum1
  [input]
  (->> input
       (map (fn [r] [(apply max r) (apply min r)]))
       (map (fn [[M m]] (- M m)))
       (reduce +)))

(defn -main
  [& args]
  (println (checksum1 input)))
