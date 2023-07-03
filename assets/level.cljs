(ns level)

(defonce level (atom 0))

(defn set-level [lvl]
  (let [level-count (. js/document (getElementById "level-count"))]
    (set! (. level-count -innerHTML) (str "Lv. " lvl))))

(defn level-up []
  (set-level (swap! level inc)))

(set-level @level)

(defn exp_up [exp-val]
  (let [exp-bar (. js/document (getElementById "exp-bar"))
        max-exp (. exp-bar -max)
        current-exp (. exp-bar -value)
        next-exp (+ current-exp exp-val)]
    (if (>= next-exp max-exp)
      (do (set! (. exp-bar -value) (- next-exp max-exp))
          (level-up))
      (set! (. exp-bar -value) next-exp))))

(set! (.-exp_up js/window) exp_up)
