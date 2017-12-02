(defproject aoc "0.1.0-SNAPSHOT"
  :description "Advent of Code 2017"
  :url "https://github.com/pawandubey/aoc"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot aoc.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
