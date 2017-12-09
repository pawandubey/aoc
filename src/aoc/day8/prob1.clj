(ns aoc.day8.prob1
  (:require [aoc.util :refer :all]
            [clojure.string :as str]))

(defn make-instruction
  [s]
  (let [[first & rest] (str/split s #" ")]
    [first (vec rest)]))

(def input
  (->> (read-input "day8/prob1")
       (str/split-lines)
       (map make-instruction)))

(defn initialize-env
  [ks]
  (zipmap ks (repeat (count ks) 0)))

(defn cond-true
  [reg op val env]
  (let [regval (env reg)
        val (Integer/parseInt val)
        testfn (fn [f] (f regval val))]
    (condp = op
      "==" (testfn =)
      "!=" (testfn not=)
      ">"  (testfn >)
      ">=" (testfn >=)
      "<"  (testfn <)
      "<=" (testfn <=))))

(defn increment-reg
  [reg val env]
  (assoc env reg (+ (env reg) (Integer/parseInt val))))

(defn decrement-reg
  [reg val env]
  (assoc env reg (- (env reg) (Integer/parseInt val))))

(defn process-instruction
  [[kreg [op val iff creg cop cval]] env]
  (if (cond-true creg cop cval env)
    (condp = op
      "inc" (increment-reg kreg val env)
      "dec" (decrement-reg kreg val env))
    env))

(defn process-instruction-queue
  [ins env]
  (let [in (first ins)
        env (process-instruction in env)
        ins (rest ins)]
    (if (seq ins)
      (recur ins env)
      env)))

(defn largest-val
  [input]
  (let [env (initialize-env (map first input))]
    (->> (process-instruction-queue input env)
         (vals)
         (apply max))))

(defn -main
  [& args]
  (println (largest-val input)))
