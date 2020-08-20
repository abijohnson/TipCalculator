package com.example.lab1cs407

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create and initialize lists (grabbing from strings.xml)
        val tipListVals = resources.getStringArray(R.array.TipAmts)
        val pplListVals = resources.getStringArray(R.array.PplAmts)
        var pplSelected : String = ""
        var tipSelected : String = ""

        //button initialization
        val calcButton = findViewById<Button>(R.id.calculateButton)

        //starting with tip amount spinner...
        val tipSpinner = findViewById<Spinner>(R.id.tipSpinner)
        if(tipSpinner != null ){
            val myTipAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tipListVals )

            tipSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("not implemented")
                }

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                    tipSelected = tipListVals[position]
                }

            }
            tipSpinner.adapter = myTipAdapter
        }

        //now to amount of people spinner...
        val peopleSpinner = findViewById<Spinner>(R.id.peopleSpinner)
        if(peopleSpinner != null ){
            val myPplAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, pplListVals )

            peopleSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("not implemented")
                }

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                    pplSelected = pplListVals[position]
                }

            }

            peopleSpinner.adapter = myPplAdapter
        }

        calcButton.setOnClickListener(View.OnClickListener {

            val totalBill = billAmt.text.toString().toDouble()

            if(pplSelected != null && tipSelected != null && totalBill != 0.0 )
            {
                val totalPerPerson : Double  = TipCalculator().calculatePerPersonTotal(totalBill, pplSelected.toInt() , tipSelected.toInt() )
                val totalTip : Double  = TipCalculator().calculateTipTotal(totalBill , tipSelected.toInt() )
                val totalResult  : Double  = TipCalculator().calculateFinalTotal( totalBill , totalTip )

                eachPayResult.text = String.format("$%.2f", totalPerPerson)
                tipResult.text = String.format("$%.2f", totalTip)
                totalAmtResult.text = String.format("$%.2f", totalResult)
            }
        })




    }

}