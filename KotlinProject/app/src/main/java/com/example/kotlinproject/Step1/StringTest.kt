package com.example.kotlinproject.Step1

import com.example.kotlinproject.TestClass
import java.util.*

class StringTest (p : (Any)->Unit) : TestClass(p) {
    override fun doTest() {
        var sName = "박모씨"
        println(sName + " - The Gamer")

        // 문자열이 내부에서 들여쓰기가 필요하면 trimIndent
        var sLines = """
            1
            2
            3
            4
            5
            6
            7
            8
            9
        """.trimIndent()

        println(sLines)

        // 위에 선언한 sName을 가져온다
        var sFormatter = "$sName <-- sName의 값"
        println(sFormatter)

        var sBash = "${ "지금 시각은 - " + Date()}"
        println(sBash);
    }
}