package com.example.munazam_astudentorganizer.Adapter

import java.text.DecimalFormat


class GPASuggestion {
    var credit: DoubleArray = doubleArrayOf(
        1.0,
        3.0,
        3.0,
        3.0,
        1.0,
        3.0,
        3.0,
        1.0,
        3.0,
        3.0,
        1.0,
        3.0,
        3.0,
        3.0,
        3.0,
        3.0,
        1.0,
        3.0,
        1.0,
        3.0,
        3.0,
        1.0,
        1.0,
        3.0,
        3.0,
        3.0,
        3.0,
        3.0,
        1.0,
        1.0,
        3.0,
        3.0,
        3.0,
        3.0,
        3.0,
        3.0,
        3.0,
        3.0,
        3.0,
        3.0,
        0.0,
        0.0,
        1.0,
        3.0,
        3.0,
        3.0,
        3.0,
        3.0,
        0.0,
        3.0,
        3.0,
        3.0,
        3.0,
        3.0,
        0.0,
        0.0
    )

    //This function is used to suggest the gpa//
    fun suggest(expected: Double, gpa: DoubleArray, cgpa: Double): DoubleArray {
        //dummy hardcoded course gpa values along with thier respcetive credit hour in gpa//


        var cgpa = cgpa
        val gpaS = doubleArrayOf(1.0, 3.0, 4.0, 3.67, 2.67, 2.67, 3.33)

        //double[] credit = {1, 3, 3, 3, 1, 3, 3};
        var min = 10.0
        var index = 0

        //variable to find min//

        //double cgpa = 3.16;
        //this is a hardcoded gpa which would be get directly from database inn spring//
        val semester = 3


        //this is a hardcoded semester which would be get directly from database inn spring//


        //expected = 3.5;
        cgpa = calculate(gpa, credit)
        println("GPA = $cgpa")
        //a would be used to create and object so that we can calculate the gpa of  each semester individually//
        var gpa_to_improve: DoubleArray

        while (cgpa < expected) {
            for (i in gpa.indices) {
                if (gpa[i] < min && gpa[i] != -1.0) {
                    min = gpa[i]
                    print(df.format(gpa[i]))
                    index = i
                }
            }
            println()
            gpa[index] = gpa[index] + 0.3335
            cgpa = calculate(gpa, credit)
            min = 10.0
        }
        return gpa
    }

    fun calculate(gpa: DoubleArray, credit: DoubleArray): Double {
        var result = 0.0
        var denominator = 0.0
        var numerator = 0.0
        for (i in gpa.indices) {
            if (gpa[i] > -1) {
                denominator = (gpa[i] * credit[i]) + denominator
                numerator = credit[i] + numerator
            }
        }
        result = denominator / numerator
        return result
    }

    fun calculate(gpa: DoubleArray): Double {
        var result = 0.0
        var denominator = 0.0
        var numerator = 0.0
        for (i in gpa.indices) {
            if (gpa[i] > -1) {
                denominator = (gpa[i] * credit[i]) + denominator
                numerator = credit[i] + numerator
            }
        }
        result = denominator / numerator
        return result
    }

    companion object {
        //This variable is used to get gpa correct to two decimal figures//
        private val df = DecimalFormat("0.00")
    }
}