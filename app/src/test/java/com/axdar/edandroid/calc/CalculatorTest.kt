package com.axdar.edandroid.calc

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

internal class CalculatorTest {

    private lateinit var calculator: Calculator

    @Throws(Exception::class)
    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun `calc addition correct`() {
        assertEquals(3, calculator.add(1, 2))
    }

    @Test
    fun `calc subtract correct`() {
        assertEquals(2, calculator.subtract(5, 3))
    }

    @Test
    fun `calc multiply correct`() {
        assertEquals(12, calculator.multiply(2, 6))
    }

    @Test
    fun `calc divide correct`() {
        assertEquals(3, calculator.divide(12, 4))
    }

    @Test
    fun `calc divide zero exception`() {
        assertEquals(0, calculator.divide(12, 0))
    }
}