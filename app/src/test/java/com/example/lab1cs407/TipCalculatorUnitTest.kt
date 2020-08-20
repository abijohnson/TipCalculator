package com.example.lab1cs407


import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TipCalculatorUnitTest {
    @Test
    fun calcTipPerPersonShouldEqual30With2People() {

        //Arrange
        val tipCal = TipCalculator()

        //Act
        val perPerson = tipCal.calculatePerPersonTotal(100.0 , 4 ,20 )

        //Assert
        assertEquals(30.00 , perPerson , 0.01 )
    }
    @Test
    fun tipTotalShouldEqual24() {

        //Arrange
        val tipCal = TipCalculator()

        //Act
        val total = tipCal.calculateTipTotal(30.0,5)

        //Assert
        assertEquals(1.5 , total , 0.01 )
    }
    @Test
    fun tipTotalShouldEqual2x() {

        //Arrange
        val tipCal = TipCalculator()

        //Act
        val total = tipCal.calculateTipTotal(234.34,10)

        //Assert
        assertEquals(23.43 , total , 0.01 )
    }
    @Test
    fun calcTipPerPersonShouldEqual60With2People() {

        //Arrange
        val tipCal = TipCalculator()

        //Act
        val perPerson = tipCal.calculatePerPersonTotal(100.0 , 2 ,10 )

        //Assert
        assertEquals(55.00 , perPerson , 0.01 )
    }
    @Test
    fun calcTipPerPersonShouldEqual29With6People() {

        //Arrange
        val tipCal = TipCalculator()

        //Act
        val perPerson = tipCal.calculatePerPersonTotal(149.50 , 6 ,20 )

        //Assert
        assertEquals(29.90 , perPerson , 0.01 )
    }
}
