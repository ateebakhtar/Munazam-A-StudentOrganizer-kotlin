package com.example.munazam_astudentorganizer.Adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.munazam_astudentorganizer.R
import java.text.DecimalFormat


class TunerView : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var movieAdapter: TunerAdapter
    lateinit var root: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.tuner_activity, container, false)

        //        tuner.add(new TunerModel("1.3","4.0","1","1","1","1","1","1","!"));
//        tuner.add(new TunerModel("1.3","4.0","1","1","1","1","1","1","!"));
//        tuner.add(new TunerModel("1.3","4.0","1","1","1","1","1","1","!"));
        val tuner: MutableList<Int> = ArrayList()
        val expanded: MutableList<Boolean> = ArrayList()
        for (i in 1..8) {
            tuner.add(i)
            expanded.add(true)
        }

        recyclerView = root.findViewById(R.id.recyclerView2)
        movieAdapter = TunerAdapter(tuner, expanded, root.getContext(), 0)
        recyclerView.setLayoutManager(LinearLayoutManager(root.getContext()))
        recyclerView.setAdapter(movieAdapter)

        val B = root.findViewById<Button>(R.id.button20)

        B.setOnClickListener { openreminder() }

        return root
    }

    fun openreminder() {
        val gpax = root!!.findViewById<EditText>(R.id.editText8)
        var counter = 0
        val df = DecimalFormat("0.00")
        println("Hello")
        val x = GPASuggestion()
        val gpa = gpax.text.toString().toDouble()
        if (gpa <= 4 && gpa > 0) {
            val result = x.suggest(gpa, movieAdapter.value, 3.0)

            for (i in 0..7) {
                if (result[i * 7] != -1.0 || result[i * 7 + 1] != -1.0 || result[i * 7 + 2] != -1.0 || result[i * 7 + 3] != -1.0 || result[i * 7 + 4] != -1.0 || result[i * 7 + 5] != -1.0 || result[i * 7 + 6] != -1.0) {
                    counter++
                }
            }
            println("GPAPAPAPAPAAPA$gpa")
            movieAdapter!!.setflag(counter)
            println()
//            TunerAdapter.setNewval(result)
            recyclerView!!.adapter = movieAdapter
        } else {
            Toast.makeText(root!!.context, "Enter a Valid GPA", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        fun newInstance(): TunerView {
            return TunerView()
        }

        var counter: Int = 0
    }
}
