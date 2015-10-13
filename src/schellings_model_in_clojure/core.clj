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
  ;(let [f (nth (deref model/population) 0)
  ;      fi @f
  ;      s (nth (deref model/population) 1)
  ;      si @s]
  ;  (Thread/sleep 1000)
  ;  (send f (fn [_] si))
  ;  (send s (fn [_] fi))




    ;;Unused
    ;(defn modify-individual [individual k v]
    ; (assoc individual k v))
    ; (doseq [agnt @model/population] (send agnt model/add-to-agent-map :test :val))


    ;(doseq [i @model/population] (send i assoc :test :value))

    ;A system state printout
    ;(println @model/population)





    ;)
  )
