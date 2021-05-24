(ns friendwall.core
  (:require [ring.adapter.jetty :refer [run-jetty]]                                                         ;; Library for Web Server
            [compojure.core :refer :all]                                                                    ;; Brings HTTP Services
            [compojure.route :as route]                                                                     ;; Allows Routes
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]                                 ;; Middlewares
            [config.core :refer [env]]                                                                      ;; Config file for .env variables
            [rum.core :refer [defc render-static-markup]])                                                  ;; Rum HTML
  (:gen-class))

(defc template [headline component]                                                                         ;; Rum Template
  [:div {:id "main-div"
         :class "main-page-div"}
   [:h1 headline]
   [:ul {:class "nav"}
    [:li [:a {:href "/"} "Home"]]
    [:li [:a {:href "/friends"} "Friends"]]]
   component])

(defc main-page [req]                                                                                       ;; Rum Controller
  [:p (str req)])

(defc friends-page []                                                                                       ;; Rum Controller
  [:p "This is the Friends page!"])

(defroutes app                                                                                              ;; Route Declaration
  (GET "/" [req] (render-static-markup (template "Hello World!" (main-page {:request req}))))               ;; GET / using main-page component
  (GET "/friends" [] (render-static-markup (template "No friends, yet :(" friends-page))))                  ;; GET /friends using friends-page component

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (run-jetty                                                                                                ;; Start the Jetty server on start-up, using app route declaration
   (wrap-defaults app site-defaults)
    {:port (:port env)}))                                                                                   ;; Reads the port from the /resources/config.edn file
