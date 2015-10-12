(ns schellings-model-in-clojure.core
  (:require
   [seesaw.core :as sc]
   [schellings-model-in-clojure.model :as model]
   [schellings-model-in-clojure.view :as view]
   [schellings-model-in-clojure.controller :as controller])
  (:gen-class))

(defn show-gui []
  (sc/native!)
  (sc/show! (sc/pack! view/main-window))
  (controller/setup-listeners)
  )

(defn -main
  "Start up the simulation of Schelling's model"
  [& args]
  (show-gui)
  ;; You should remove everything from here down. I only
  ;; included this to "force" some sort of change in the
  ;; system so I could confirm that all my watching and
  ;; binding was wired up correctly.
  (let [f (nth (deref model/positions) 0)
        fi @f
        s (nth (deref model/positions) 0)
        si @s]
    (Thread/sleep 1000)
    (swap! f (fn [_] si))
    (swap! s (fn [_] fi))
            (println " ")
    (swap! s (fn [_] si))




    (doseq [agnt @model/population] (send agnt model/add-to-agent-map :test :val))


    ;(doseq [i @model/population] (send i assoc :test :value))
    (println @model/population)





    )
  )
