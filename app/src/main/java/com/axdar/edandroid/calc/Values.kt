package com.axdar.edandroid.calc

class Values(
    var firstOperand: String = "",
    var secondOperand: String = "",
    var result: String = "",
) {
    fun equalsToValues(values: Values): Boolean {
        return firstOperand == values.firstOperand
                && secondOperand == values.secondOperand
                && result == values.result
    }
}