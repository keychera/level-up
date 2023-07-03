(defn my-alert []
  (js/alert "Hello from scittle!"))
;; export function to use from JavaScript:
(set! (.-my_alert js/window) my-alert)