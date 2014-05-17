(ns twister-caller.core-spec
    (:use
        [speclj.core]
        [twister-caller.core]))

(describe "Truth"

    (it "is true"
        (should true))

    (it "is false"
        (should-not false))

    (it "calls functions"
        (should (testSpec))))
