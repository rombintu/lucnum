package com.example.lucnum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

fun getIntList(date: String): MutableList<Int> {
    var allNum = mutableListOf<Int>()
    for (val1 in date.split(".")) {
        for (val2 in val1) {
            allNum.add(val2.toString().toInt())
        }
    }

    return allNum
}

fun getSumOfIntStr(num: Int): Int {
    var sum = 0
    num.toString().forEach { n ->
        sum += n.toString().toInt()
    }
    return sum
}

fun addNumToList(arr: MutableList<Int>, num: Int): MutableList<Int> {
    num.toString().forEach { n ->
        arr.add(n.toString().toInt())
    }
    return arr
}

fun countIntOfArr(arr: MutableList<Int>): MutableMap<Int, Int> {
    val map = mutableMapOf<Int, Int>(
        0 to 0, 1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 6 to 0, 7 to 0, 8 to 0, 9 to 0)
    for (el in arr) {
        var current: Int? = map[el]
        if (current != null) {
            map[el] = current.toInt()+1
        }
    }
    return  map

}

fun mapToString(map: MutableMap<Int, Int>): String {
    var buffer = ""
    for ((k, v) in map) {
        buffer += "$k -> $v\n"
    }
    return buffer
}

class CompiledActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compiled)

        var datetime = intent.getStringExtra("context").toString()

        var luckNumText = findViewById<TextView>(R.id.textView7) as TextView
        var textWidget = findViewById<TextView>(R.id.textView8) as TextView

        var intArrNum = getIntList(datetime)
        var sumBefore = intArrNum.sum()
        var sumAfter = sumBefore
        var luckNum = 0
        var simpleNum = 0
        var payload1 = 0
        var payload2 =0

        if (intArrNum[4] == 1) {
            sumAfter += -2
        } else {
            sumAfter += 19
        }

        payload1 = getSumOfIntStr(sumBefore)
        payload2 = getSumOfIntStr(sumAfter)
        luckNum = getSumOfIntStr(payload1)
        simpleNum = getSumOfIntStr(payload2)

        intArrNum = addNumToList(intArrNum, sumBefore)
        intArrNum = addNumToList(intArrNum, sumAfter)
        intArrNum = addNumToList(intArrNum, payload1)
        intArrNum = addNumToList(intArrNum, payload2)
        intArrNum = addNumToList(intArrNum, simpleNum)

        luckNumText.text = luckNum.toString()
        textWidget.text = mapToString(countIntOfArr(intArrNum))
    }
}