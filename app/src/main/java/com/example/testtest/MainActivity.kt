package com.example.testtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        // Task 1
        val average = calculateAverage(array)
        Log.d("MainActivity", "Average: $average")

        // Task 2
        val count = countElementsGreaterThanMean(array)
        Log.d("MainActivity", "Количество элементов больше среднего: $count")

        // Task 3
        val names = listOf("Bek", "Anur", "Ali", "Salima", "Bekbol", "Emir", "Sardar", "Alina", "Aidai", "Nurbek")
        val myName = buildMyName(names)
        Log.d("MainActivity", "Имена: $names")
        Log.d("MainActivity", "Собранное имя: $myName")

        // Task 4
        val secondLargest = findSecondLargest(array)
        Log.d("MainActivity", "Второе по величине число: $secondLargest")

        // Task 5
        val newArray = removeMinElement(array)
        Log.d(
            "MainActivity",
            "Массив без минимального элемента: ${newArray.joinToString(", ")}"
        )
    }


    fun calculateAverage(array: IntArray): Double {
        return array.average()
    }


    fun countElementsGreaterThanMean(array: IntArray): Int {
        val mean = array.average()
        return array.count { it > mean }
    }


//    val names =
//        listOf("Bek", "Anur", "Ali", "Salima", "Bekbol", "Emir", "Sardar", "Alina", "Aidai", "Nurbek")
//
//    val myName = "Baibol"
//    fun buildMyName(names: List<String>): String {
//        val letters = listOf(
//            names[0][0],
//            names[1][0],
//            names[2][2],
//            names[4][0],
//            names[4][4],
//            names[2][1]
//        )
//        return letters.joinToString("")
//    }
    fun buildMyName(names: List<String>): String {
        val targetName = "Baibol"
        val letters = mutableListOf<Char>()
        for (i in targetName.indices) {
            val letter = targetName[i]
            for (name in names) {
                if (name.contains(letter, ignoreCase = true)) {
                    letters.add(letter)
                    break
                }
            }
        }
        return letters.joinToString("")
    }
    fun findSecondLargest(array: IntArray): Int? {
        if (array.size < 2) return null
        var first = Int.MIN_VALUE
        var second = Int.MIN_VALUE
        for (num in array) {
            if (num > first) {
                second = first
                first = num
            } else if (num > second && num != first) {
                second = num
            }
        }
        return if (second == Int.MIN_VALUE) null else second
    }


    fun removeMinElement(array: IntArray): IntArray {
        val minElement = array.minOrNull() ?: return array
        return array.filter { it != minElement }.toIntArray()
    }


}