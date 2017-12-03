(ns aoc.util
  (:require [clojure.java.io :as io]))

(defn read-input [s]
  (-> s
      io/resource
      io/reader
      slurp))

(defn parse-int [x] (Integer/parseInt x))

(defn parse-int-list [x] (map parse-int x))
