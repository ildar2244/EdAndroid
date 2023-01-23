package com.axdar.edandroid.calc

import android.content.SharedPreferences

const val KEY_FIRST_OPERAND = "first_operand"
const val KEY_SECOND_OPERAND = "second_operand"
const val KEY_RESULT = "result"

class SaveValuesHelper(
    private val sharedPreferences: SharedPreferences
) {

    fun saveValues(values: Values) {
        sharedPreferences.edit()
            .putString(KEY_FIRST_OPERAND, values.firstOperand)
            .putString(KEY_SECOND_OPERAND, values.secondOperand)
            .putString(KEY_RESULT, values.result)
            .apply()
    }

    fun readValues(): Values {
        val values = Values()
        values.firstOperand = sharedPreferences.getString(KEY_FIRST_OPERAND, "").toString()
        values.secondOperand = sharedPreferences.getString(KEY_SECOND_OPERAND, "").toString()
        values.result = sharedPreferences.getString(KEY_RESULT, "").toString()
        return values
    }
}