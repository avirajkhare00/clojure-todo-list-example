(ns todo-list.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]))

(defn welcome
  "A ring handler to process all requests sent to the webapp"
  [request]
  
  (if (= "/" (:uri request))
    
    {
     :status 200
     :body
     "<h1>Hello, Clojure World</h1>
     <p>This is my first clojure webapp.
     I am very happy about it.<p>
     <h2>Hot auto reloading is also enabled :)</h2>
     "
     :headers {}}
    
    {
     :status 404
     :body "<h1>Page you are looking is not found(404).<h1>"
     :headers {}}))

(defn -main
  "A very simple web server using Ring & Jetty"
  [port-number]
  (jetty/run-jetty welcome
    {:port (Integer. port-number)}))


(defn -dev-main
  "A very simple web server using Ring & Jetty that reloads code changes via the development profile of Leiningen"
  [port-number]
  (jetty/run-jetty (wrap-reload #'welcome)
     {:port (Integer. port-number)}))
