(ns level)

(defn exp_up []
  (let [exp-bar (. js/document (getElementById "exp-bar"))
        exp-val (. exp-bar -value)]
    (set! (. exp-bar -value) (+ exp-val 5))))

(set! (.-exp_up js/window) exp_up)
