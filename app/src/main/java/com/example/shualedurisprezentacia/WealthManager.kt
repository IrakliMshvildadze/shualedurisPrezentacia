package com.example.shualedurisprezentacia

class WealthManager(birthDay: Int = 15) {
    
    // ირაკლი (6) + მშვილდაძე (9) = 15
    // K = (6 + 9) / birthDay
    private val k: Double = 15.0 / birthDay.toDouble()

    fun calculateFinalSavings(income: Double, expenses: Double): Double {
        return (income - expenses) * k
    }

    fun getKValue(): Double = k
}