package com.example.shualedurisprezentacia

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult

class InputFragment : Fragment(R.layout.fragment_input) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etIncome = view.findViewById<EditText>(R.id.imdze_et_income)
        val etExpenses = view.findViewById<EditText>(R.id.imdze_et_expenses)
        val btnSave = view.findViewById<Button>(R.id.imdze_btn_save)

        btnSave.setOnClickListener {
            val incomeStr = etIncome.text.toString()
            val expensesStr = etExpenses.text.toString()

            var isValid = true

            if (incomeStr.isEmpty()) {
                etIncome.error = "Please enter income"
                isValid = false
            }

            if (expensesStr.isEmpty()) {
                etExpenses.error = "Please enter expenses"
                isValid = false
            }

            if (isValid) {
                val income = incomeStr.toDouble()
                val expenses = expensesStr.toDouble()

                setFragmentResult("wealth_data", bundleOf(
                    "income" to income,
                    "expenses" to expenses
                ))
            }
        }
    }
}