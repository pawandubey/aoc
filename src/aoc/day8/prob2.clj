(ns aoc.day8.prob2
  (:require [aoc.util :refer :all]
            [aoc.day8.prob1 :as prob1]))

(defn process-instruction
  [[kreg [op val iff creg cop cval]] env]
  (if (prob1/cond-true creg cop cval env)
    (condp = op
      "inc" (prob1/increment-reg kreg val env)
      "dec" (prob1/decrement-reg kreg val env))
    env))

(defn process-instruction-queue
  [ins maxv env]
  (let [in (first ins)
        env (process-instruction in env)
        ins (rest ins)
        maxv (max maxv (apply max (vals env)))]
    (if (seq ins)
      (recur ins maxv env)
      maxv)))

(defn largest-val
  [input]
  (let [env (prob1/initialize-env (map first input))
        maxv 0]
    (process-instruction-queue input maxv env)))

(defn -main
  [& args]
  (println (largest-val prob1/input)))
