(ns todo-list.core

  (:require [ring.adapter.jetty :as jetty]))

(defn -main
  "A very simple web server using Ring & Jetty"
  [port-number]
  (jetty/run-jetty
     (fn [request] {:status 200}
                   :body "<h1>This is my first webapp in clojure.</h1>"
                   :headers {})
     {:port (Integer. port-number)}))


                  

  
