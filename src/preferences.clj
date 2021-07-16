(ns preferences)


(defn read-in [file]
  (-> file slurp clojure.string/split-lines))

(defn prompt
  "Asks the user to compare and waits for input."
  ([a b]
   (println "Choose:\n[1]" (str a) "\n[2]" (str b))
   (let [choice (clojure.string/trim (read-line))]
     (case choice
       "1" true
       "2" false
       false))))

(defn -main [& args]
  (let [filename (first args)]
    (println (str (sort prompt (-> filename read-in shuffle))))))
