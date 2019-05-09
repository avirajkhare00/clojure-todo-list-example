(defproject todo-list "0.1.0-SNAPSHOT"
  :description "A todo list server side webapp using Ring and Compojure"
  :url "https://github.com/avirajkhare00/clojure-todo-list-example"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ring "1.7.1"]
                 [compojure "1.6.1"]]
  :repl-options {:init-ns todo-list.core}
  
  :main todo-list.core
  
  :profiles {:dev 
             {:main todo-list.core/-dev-main}})
