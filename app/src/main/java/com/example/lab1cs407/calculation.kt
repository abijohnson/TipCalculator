package com.example.lab1cs407

const val HUNDRED_PERCENT = 100.00

class TipCalculator {

    fun calculatePerPersonTotal(totalBill : Double, numberOfPeople : Int, tipPercent : Int) : Double {

        val totalExpense = ((HUNDRED_PERCENT + tipPercent) / HUNDRED_PERCENT) * totalBill
        val perPersonTotal = totalExpense / numberOfPeople

        return perPersonTotal

    }

    fun calculateTipTotal(totalBill : Double, tipPercent : Int) : Double {

        val tip = ( (tipPercent.toDouble() / 100 ) * totalBill )

        return tip

    }

    fun calculateFinalTotal(totalBill : Double, tipAmount : Double) : Double {

        val totalAmount = totalBill + tipAmount

        return totalAmount

    }
}