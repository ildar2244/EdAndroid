package com.axdar.edandroid.mock

import android.content.Context
import com.axdar.edandroid.R
import org.junit.jupiter.api.Assertions.*
import org.hamcrest.CoreMatchers.`is` as Is
import org.junit.Assert.*


import org.junit.runner.RunWith
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class UriValidatorTest {

    companion object {
        private const val NOTHING: String = "Nothing"
        private const val URL: String = "Url"
        private const val FILE: String = "File"
    }

    private lateinit var uriValidator: UriValidator
    private lateinit var mockContext: Context

    @Before
    fun setUp() {
        mockContext = Mockito.mock(Context::class.java)
        Mockito.`when`(mockContext.getString(R.string.nothing)).thenReturn(NOTHING)
        Mockito.`when`(mockContext.getString(R.string.url)).thenReturn(URL)
        Mockito.`when`(mockContext.getString(R.string.file)).thenReturn(FILE)
        uriValidator = UriValidator(mockContext)
    }

    @Test
    fun validate() {
        assertThat(uriValidator.validate("http://google.com"), Is(URL))
        assertThat(uriValidator.validate("file://sdcard/DCIM/img001.jpg"), Is(FILE))
        assertThat(uriValidator.validate("bla-bla-bla"), Is(NOTHING))
    }
}