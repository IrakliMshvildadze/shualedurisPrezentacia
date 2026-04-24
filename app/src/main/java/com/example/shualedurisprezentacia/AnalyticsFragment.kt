package com.example.shualedurisprezentacia

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

class AnalyticsFragment : Fragment(R.layout.fragment_analytics) {

    private val wealthManager = WealthManager(15) // Assuming birthday is 15

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvIncomeValue = view.findViewById<TextView>(R.id.imdze_tv_income_value)
        val tvExpensesValue = view.findViewById<TextView>(R.id.imdze_tv_expenses_value)
        val tvSavingsValue = view.findViewById<TextView>(R.id.imdze_tv_savings_value)

        setFragmentResultListener("wealth_data") { _, bundle ->
            val income = bundle.getDouble("income", 0.0)
            val expenses = bundle.getDouble("expenses", 0.0)

            val finalSavings = wealthManager.calculateFinalSavings(income, expenses)

            tvIncomeValue.text = income.toString()
            tvExpensesValue.text = expenses.toString()
            tvSavingsValue.text = String.format("%.2f", finalSavings)
        }
    }
}