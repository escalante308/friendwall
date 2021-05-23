(defproject friendwall "0.1.0-SNAPSHOT"
  :description "Mi First Demo App using Clojure"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring "1.8.0"]
                 [compojure "1.6.2"]
                 [ring/ring-defaults "0.3.2"]]
  :main ^:skip-aot friendwall.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.???compiler.direct-linking=true"]}})