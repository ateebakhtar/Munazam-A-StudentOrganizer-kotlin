package com.example.munazam_astudentorganizer.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.munazam_astudentorganizer.Adapter.TunerAdapter.TunerAH
import com.example.munazam_astudentorganizer.R
import java.text.DecimalFormat

class TunerAdapter(
    movieList: List<Int>,
    expandede: MutableList<Boolean>,
    context: Context,
    flag: Int
) : RecyclerView.Adapter<TunerAH>() {
    var expandede: MutableList<Boolean>
    var sizer: List<Int>
    var cours: Array<TextView?> = arrayOfNulls(7)

    var flag = 0
    var value: DoubleArray = DoubleArray(60)
    var newval: DoubleArray? = DoubleArray(60)

    var cx: Context
    fun setflag(i: Int) {
        flag = i
    }

    init {
        this.flag = flag
        this.expandede = expandede
        cx = context
        this.sizer = movieList

        for (i in 0..59) {
            newval?.set(i, -1.0)
            value[i] = -1.0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TunerAH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.tuner_template, parent, false)
        return TunerAH(view)
    }

    override fun onBindViewHolder(holder: TunerAH, position: Int) {
        holder.semester.text = "Semester: " + sizer[position]

        val obj = arrayOf<String?>(
            "0.00",
            "1.00",
            "1.33",
            "1.67",
            "2.00",
            "2.33",
            "2.67",
            "3.00",
            "3.33",
            "3.67",
            "4.00"
        )


        when (sizer[position]) {
            1 -> {
                val courses = cx.resources.getStringArray(R.array.s1)
                var i = 0
                while (i < courses.size) {
                    cours[i]!!.text = courses[i]
                    i++
                }
            }

            2 -> {
                val courses1 = cx.resources.getStringArray(R.array.s2)
                var i = 0
                while (i < courses1.size) {
                    cours[i]!!.text = courses1[i]
                    i++
                }
            }

            3 -> {
                val courses2 = cx.resources.getStringArray(R.array.s3)
                var i = 0
                while (i < courses2.size) {
                    //System.out.printf(courses[i]);
                    cours[i]!!.text = courses2[i]
                    i++
                }
            }

            4 -> {
                val courses3 = cx.resources.getStringArray(R.array.s4)
                var i = 0
                while (i < courses3.size) {
                    //System.out.printf(courses[i]);
                    cours[i]!!.text = courses3[i]
                    i++
                }
            }

            5 -> {
                val courses4 = cx.resources.getStringArray(R.array.s5)
                var i = 0
                while (i < courses4.size) {
                    //System.out.printf(courses[i]);
                    cours[i]!!.text = courses4[i]
                    i++
                }
            }

            6 -> {
                val courses5 = cx.resources.getStringArray(R.array.s6)
                var i = 0
                while (i < courses5.size) {
                    //System.out.printf(courses[i]);
                    cours[i]!!.text = courses5[i]
                    i++
                }
            }

            7 -> {
                val courses6 = cx.resources.getStringArray(R.array.s7)
                var i = 0
                while (i < courses6.size) {
                    //System.out.printf(courses[i]);
                    cours[i]!!.text = courses6[i]
                    i++
                }
            }

            8 -> {
                val courses7 = cx.resources.getStringArray(R.array.s8)
                var i = 0
                while (i < courses7.size) {
                    System.out.printf(courses7[i])
                    cours[i]!!.text = courses7[i]
                    i++
                }
            }
        }
        val aa0: ArrayAdapter<*> = ArrayAdapter<Any?>(cx, android.R.layout.simple_spinner_item, obj)
        val aa1: ArrayAdapter<*> = ArrayAdapter<Any?>(cx, android.R.layout.simple_spinner_item, obj)
        val aa2: ArrayAdapter<*> = ArrayAdapter<Any?>(cx, android.R.layout.simple_spinner_item, obj)
        val aa3: ArrayAdapter<*> = ArrayAdapter<Any?>(cx, android.R.layout.simple_spinner_item, obj)
        val aa4: ArrayAdapter<*> = ArrayAdapter<Any?>(cx, android.R.layout.simple_spinner_item, obj)
        val aa5: ArrayAdapter<*> = ArrayAdapter<Any?>(cx, android.R.layout.simple_spinner_item, obj)
        val aa6: ArrayAdapter<*> = ArrayAdapter<Any?>(cx, android.R.layout.simple_spinner_item, obj)
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(cx, android.R.layout.simple_spinner_item, obj)

        val temp = position

        holder.spins[0]!!.adapter = aa0
        holder.spins[1]!!.adapter = aa1
        holder.spins[2]!!.adapter = aa2
        holder.spins[3]!!.adapter = aa3
        holder.spins[4]!!.adapter = aa4
        holder.spins[5]!!.adapter = aa5
        holder.spins[6]!!.adapter = aa6


        val isExpanded = expandede[position]
        holder.expandableLayout.visibility = if (isExpanded) View.VISIBLE else View.GONE
        val df = DecimalFormat("0.00")

        println(flag.toString() + " flagg")
        if (flag > 0) {
            println("Flagging the way" + (newval?.get(7 * temp) ?: 0.0))

            holder.grades[0]!!.text = "" + df.format(newval?.get(7 * temp) ?: 0.0)
            holder.grades[1]!!.text = "" + df.format(newval?.get(7 * temp + 1) ?: 0.0)
            holder.grades[2]!!.text = "" + df.format(newval?.get(7 * temp + 2) ?: 0.0)
            holder.grades[3]!!.text = "" + df.format(newval?.get(7 * temp + 3) ?: 0.0)
            holder.grades[4]!!.text = "" + df.format(newval?.get(7 * temp + 4) ?: 0.0)
            holder.grades[5]!!.text = "" + df.format(newval?.get(7 * temp + 5) ?: 0.0)
            holder.grades[6]!!.text = "" + df.format(newval?.get(7 * temp + 6) ?: 0.0)

            flag--
            return
        }



        holder.spins[0]!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                println(temp)

                value[7 * temp] = obj[position]!!.toDouble()
                holder.grades[0]!!.text = obj[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // can leave this empty
            }
        }

        holder.spins[1]!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                value[7 * temp + 1] = obj[position]!!.toDouble()
                holder.grades[1]!!.text = "" + obj[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // can leave this empty
            }
        }

        holder.spins[2]!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                value[7 * temp + 2] = obj[position]!!.toDouble()
                holder.grades[2]!!.text = obj[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // can leave this empty
            }
        }

        holder.spins[3]!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                value[7 * temp + 3] = obj[position]!!.toDouble()
                holder.grades[3]!!.text = obj[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // can leave this empty
            }
        }

        holder.spins[4]!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                value[7 * temp + 4] = obj[position]!!.toDouble()
                holder.grades[4]!!.text = obj[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // can leave this empty
            }
        }

        holder.spins[5]!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                value[7 * temp + 5] = obj[position]!!.toDouble()
                holder.grades[5]!!.text = obj[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // can leave this empty
            }
        }

        holder.spins[6]!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                value[7 * temp + 6] = obj[position]!!.toDouble()
                holder.grades[6]!!.text = obj[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // can leave this empty
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return sizer.size
    }

    inner class TunerAH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var x: Spinner? = null

        var cgpa: TextView = itemView.findViewById(R.id.textView28)
        var semester: TextView = itemView.findViewById(R.id.textView25)
        var calculategpa: Button = itemView.findViewById(R.id.button20)
        var grades: Array<TextView?> = arrayOfNulls(7)
        var spins: Array<Spinner?> = arrayOfNulls(7)


        //TextView[] cours = new TextView[7];
        var expandableLayout: ConstraintLayout = itemView.findViewById(R.id.constraintLayout3)


        init {
            cours[0] = itemView.findViewById(R.id.textView44)
            cours[1] = itemView.findViewById(R.id.textView31)
            cours[2] = itemView.findViewById(R.id.textView34)
            cours[3] = itemView.findViewById(R.id.textView35)
            cours[4] = itemView.findViewById(R.id.textView36)
            cours[5] = itemView.findViewById(R.id.textView33)
            cours[6] = itemView.findViewById(R.id.textView32)

            spins[0] = itemView.findViewById(R.id.spinner5)
            spins[1] = itemView.findViewById(R.id.spinner6)
            spins[2] = itemView.findViewById(R.id.spinner7)
            spins[3] = itemView.findViewById(R.id.spinner8)
            spins[4] = itemView.findViewById(R.id.spinner9)
            spins[5] = itemView.findViewById(R.id.spinner10)
            spins[6] = itemView.findViewById(R.id.spinner11)

            grades[0] = itemView.findViewById(R.id.textView37)
            grades[1] = itemView.findViewById(R.id.textView38)
            grades[2] = itemView.findViewById(R.id.textView39)
            grades[3] = itemView.findViewById(R.id.textView40)
            grades[4] = itemView.findViewById(R.id.textView41)
            grades[5] = itemView.findViewById(R.id.textView42)
            grades[6] = itemView.findViewById(R.id.textView43)

            calculategpa.setOnClickListener {
                val arr = DoubleArray(7)
                val cr = doubleArrayOf(1.0, 3.0, 1.0, 3.0, 3.0, 3.0, 3.0)
                println(adapterPosition)
                for (i in 0..6) {
                    arr[i] = grades[i]?.getText().toString().toDouble()
                    println(arr[i])
                }
                val x = GPASuggestion()

                var gpa = x.calculate(arr, cr)

                gpa = x.calculate(value, value)
                cgpa.text = "" + gpa
            }


            semester.setOnClickListener { //                    TunerModel tuner = tunerlist.get(getAdapterPosition());
//                    tuner.setExpanded(!tuner.isExpanded());
//                    notifyItemChanged(getAdapterPosition());

                val x = expandede[adapterPosition]
                expandede[adapterPosition] = !x
                notifyItemChanged(adapterPosition)
            }
        }

    }

}
