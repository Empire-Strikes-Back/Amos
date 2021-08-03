#!/bin/bash

repl(){
  clj \
    -X:repl deps-repl.core/process \
    :main-ns knight.main \
    :port 7788 \
    :host '"0.0.0.0"' \
    :repl? true \
    :nrepl? false
}

main(){
  clojure \
    -J-Dclojure.core.async.pool-size=1 \
    -J-Dclojure.compiler.direct-linking=false \
    -M -m knight.main
}

uberjar(){
  clojure \
    -X:uberjar hf.depstar/uberjar \
    :aot true \
    :jar out/knight.standalone.jar \
    :verbose false \
    :main-class knight.main
  mkdir -p out/jpackage-input
  mv out/knight.standalone.jar out/jpackage-input/
}


"$@"