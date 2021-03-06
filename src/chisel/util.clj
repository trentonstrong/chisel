;; See README for license information
(ns chisel.util
  "Utility function needed to access MALLET protected fields")

(defn get-private-field
  "Access private field of a Java object (credit: kyle smith on Google Groups)"
  [instance field-name]
  (. (doto (first (filter #(.. %1 getName (equals field-name))
                          (.. instance getClass getDeclaredFields)))       
       (.setAccessible true))
     (get instance)))
