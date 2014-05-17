(ns twister-caller.core
  ( :use clojure.java.shell))

;;C:\Program Files\Jampal>echo "red blue yellow green left right hand foot" | C:\Windows\System32\cscript.exe "C:\Program Files\Jampal\ptts.vbs"

(def delay 3000)

(def cscript "C:\\Windows\\System32\\cscript.exe")
(def jampal "C:\\Program Files\\Jampal\\ptts.vbs")
(defn say [something]
  (sh cscript jampal
      :in (str something)))

(defn randomly-choose [& args] ((vec args) (rand-int (count args))))

(defn random-turn []
  (clojure.string/join " "
                       [(randomly-choose "left" "right")
                        (randomly-choose "hand" "foot")
                        (randomly-choose "red" "blue" "yellow" "green")]))

(def run nil)
(def run :true)

(defn -main
  [& [args]]
    (let [delay (if args
                  (Integer/parseInt args)
                  delay)]
      (while run (Thread/sleep 3000) (say (random-turn)))))
