(ns aoc.util
  (:require [clojure.java.io :as io]))

(defn read-input [s]
  (-> s
      io/resource
      io/reader
      slurp))
