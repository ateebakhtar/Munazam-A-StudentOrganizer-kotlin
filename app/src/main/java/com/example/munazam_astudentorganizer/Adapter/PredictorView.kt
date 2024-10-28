package com.example.munazam_astudentorganizer.Adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.munazam_astudentorganizer.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class PredictorView : Fragment() {
    lateinit var root: View
    lateinit var c1: EditText
    lateinit var c2: EditText
    lateinit var c3: EditText
    lateinit var finalgrade: EditText
    lateinit var c4: EditText
    lateinit var grade1: Spinner
    lateinit var grade2: Spinner
    lateinit var grade3: Spinner
    lateinit var q1: EditText
    lateinit var q2: EditText
    lateinit var q3: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.predictor_activity, container, false)

        c1 = root.findViewById(R.id.mymark1)
        c2 = root.findViewById(R.id.mymark2)
        c3 = root.findViewById(R.id.mymark3)
        c4 = root.findViewById(R.id.mymark)

        grade1 = root.findViewById(R.id.spin1)
        grade2 = root.findViewById(R.id.spin2)
        grade3 = root.findViewById(R.id.spin3)

        finalgrade = root.findViewById(R.id.finalgrade)

        q1 = root.findViewById(R.id.totalmark1)
        q2 = root.findViewById(R.id.totalmark2)
        q3 = root.findViewById(R.id.totalmark3)

        q1.setFocusable(false)
        q1.setClickable(false)
        q2.setFocusable(false)
        q2.setClickable(false)
        q3.setFocusable(false)
        q3.setClickable(false)
        finalgrade.setFocusable(false)
        finalgrade.setClickable(false)

        val objects = arrayOf<String?>("A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D")


        val adapter: ArrayAdapter<*> =
            ArrayAdapter<Any?>(root.getContext(), android.R.layout.simple_list_item_1, objects)
        grade1.setAdapter(adapter)
        grade2.setAdapter(adapter)
        grade3.setAdapter(adapter)

        val fab = root.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val mymark = c1.getText().toString().toFloat()
            val mymark1 = c2.getText().toString().toFloat()
            val mymark2 = c3.getText().toString().toFloat()
            val mymark3 = c4.getText().toString().toFloat()

            val gradex = grade1.getSelectedItem().toString()
            val gradey = grade2.getSelectedItem().toString()
            val gradez = grade3.getSelectedItem().toString()
            if (mymark > 50) {
                c1.setError("Marks has to be less than 50")
            } else if (mymark1 > 50) {
                c2.setError("Marks has to be less than 50")
            } else if (mymark2 > 50) {
                c3.setError("Marks has to be less than 50")
            } else if (mymark3 > 50) {
                c4.setError("Marks has to be less than 50")
            } else {
                val finalmarks1 = if (gradex == "A") {
                    86f
                } else if (gradex == "A-") {
                    82f
                } else if (gradex == "B+") {
                    78f
                } else if (gradex == "B") {
                    74f
                } else if (gradex == "B-") {
                    70f
                } else if (gradex == "C+") {
                    66f
                } else if (gradex == "C") {
                    62f
                } else if (gradex == "C-") {
                    58f
                } else if (gradex == "D+") {
                    54f
                } else {
                    50f
                }

                val finalmarks2 = if (gradey == "A") {
                    86f
                } else if (gradey == "A-") {
                    82f
                } else if (gradey == "B+") {
                    78f
                } else if (gradey == "B") {
                    74f
                } else if (gradey == "B-") {
                    70f
                } else if (gradey == "C+") {
                    66f
                } else if (gradey == "C") {
                    62f
                } else if (gradey == "C-") {
                    58f
                } else if (gradey == "D+") {
                    54f
                } else {
                    50f
                }


                val finalmarks3 = if (gradez == "A") {
                    86f
                } else if (gradez == "A-") {
                    82f
                } else if (gradez == "B+") {
                    78f
                } else if (gradez == "B") {
                    74f
                } else if (gradez == "B-") {
                    70f
                } else if (gradez == "C+") {
                    66f
                } else if (gradez == "C") {
                    62f
                } else if (gradez == "C-") {
                    58f
                } else if (gradez == "D+") {
                    54f
                } else {
                    50f
                }


                val factor1 = finalmarks1 / mymark
                println("" + factor1)
                val factor2 = finalmarks2 / mymark1
                println("" + factor2)
                val factor3 = finalmarks3 / mymark2
                println("" + factor3)


                var avgfactor = factor1 + factor2 + factor3
                avgfactor = avgfactor / 3
                println("" + avgfactor)
                println("" + avgfactor)


                val final4marks = avgfactor * mymark3

                if (final4marks > 86) {
                    finalgrade.setText("A")
                } else if (final4marks > 82) {
                    finalgrade.setText("A-")
                } else if (final4marks > 78) {
                    finalgrade.setText("B+")
                } else if (final4marks > 74) {
                    finalgrade.setText("B")
                } else if (final4marks > 70) {
                    finalgrade.setText("B")
                } else if (final4marks > 66) {
                    finalgrade.setText("C+")
                } else if (final4marks > 62) {
                    finalgrade.setText("C")
                } else if (final4marks > 58) {
                    finalgrade.setText("C-")
                } else if (final4marks > 54) {
                    finalgrade.setText("D+")
                } else {
                    finalgrade.setText("D")
                }
            }
        }


        return root
    }

    companion object {
        fun newInstance(): PredictorView {
            return PredictorView()
        }
    }
}
