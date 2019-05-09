(ns todo-list.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]))

(defn welcome
  "A ring handler to process all requests sent to the webapp"
  [request]
  {:status 200
   :body "<h1>Hello</h1>
         <p>This is my first clojure webapp.</p>"
   :headers {}})

(defn about
  "About me route"
  [request]
  {:status 200
   :body "<h1>Hello my name is Aviraj Khare</h1>"
   :headers {}})

(def operands {"+" + "-" - "*" * ":" /})

(defn calculator
  "A basic calculator to perform basic calculations"
  [request]
  (let [a (Integer. (get-in request [:route-params :a]))
        b (Integer. (get-in request [:route-params :b]))
        op (get-in request [:route-params :op])
        f (get operands op)]
    (if f
        {:status 200
         :body (str (f a b))
         :headers {}}
        {:status 404
         :body "Sorry unknown operator"
         :headers{}})))

(defroutes app
  (GET "/" [] welcome)
  (GET "/about" [] about)
  (GET "/calculator/:a/:op/:b" [] calculator)
  (not-found "<h1>404</h1>"))
    

(defn -main
  "A very simple web server using Ring & Jetty"
  [port-number]
  (jetty/run-jetty app
    {:port (Integer. port-number)}))


(defn -dev-main
  "A very simple web server using Ring & Jetty that reloads code changes via the development profile of Leiningen"
  [port-number]
  (jetty/run-jetty (wrap-reload #'app)
     {:port (Integer. port-number)}))
