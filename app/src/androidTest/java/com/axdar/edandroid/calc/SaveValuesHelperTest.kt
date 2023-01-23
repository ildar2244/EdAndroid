package com.axdar.edandroid.calc

import android.content.Context
import android.content.SharedPreferences
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test

internal class SaveValuesHelperTest {

    @Throws(Exception::class)
    @Test
    fun saveAndReadValues() {
        val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext
        val sharedPreferences: SharedPreferences = appContext.getSharedPreferences("test", 0)
        sharedPreferences.edit().clear().apply()
        val saveValuesHelper = SaveValuesHelper(sharedPreferences)

        val valuesOnSave = Values("5", "2", "10")
        saveValuesHelper.saveValues(valuesOnSave)

        val valuesOnRead = saveValuesHelper.readValues()

        assertEquals(true, valuesOnSave.equalsToValues(valuesOnRead))
    }
}