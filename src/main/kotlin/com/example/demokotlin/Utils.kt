package com.example.demokotlin

import java.io.PrintWriter
import java.io.StringWriter
import java.util.ArrayList
import java.util.HashMap

class Utils {

    fun convertToListOfMap(list: List<Any?>, columnNames: List<String>): List<Map<String, Any>>? {
        val result = ArrayList<Map<String, Any>>()

        for (item in list) {
            val itemArr = item as Array<*>
            val temp = HashMap<String, Any>()

            itemArr.forEachIndexed { index, it ->
                if(it!=null)
                    temp[columnNames[index]] = it
            }

            result.add(temp)
        }
        return result
    }

    fun getStackTrace(throwable: Throwable): String {
        val sw = StringWriter()
        val pw = PrintWriter(sw, true)
        throwable.printStackTrace(pw)
        return sw.buffer.toString()
    }

}