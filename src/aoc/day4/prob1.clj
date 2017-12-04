(ns aoc.day4.prob1
  (:require [aoc.util :refer :all]
            [clojure.string :as str]))

(def input (read-input "day4/prob1"))

(defn passphrases
  [input]
  (->> input
       (str/split-lines)))

#_(passphrases input)

(defn valid-passphrase?
  [s]
  (->> s
       (#(str/split % #"\s+"))
       (apply distinct?)))

#_(valid-passphrase? "abc def ghi abc")

(defn count-valid-passphrases
  [input]
  (->> (passphrases input)
       (filter valid-passphrase?)
       (count)))

#_(count-valid-passphrases input)

(defn -main
  [& args]
  (println (count-valid-passphrases input)))
