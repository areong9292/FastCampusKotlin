package com.example.kotlinproject.Step1

import com.example.kotlinproject.TestClass

class ConditionTest (p : (Any)->Unit) : TestClass(p) {
    override fun doTest() {
        ifTest("Test")
        ifTest(17.0f)
        ifTest(2)
        ifTest(null)

        loopTest(5)

        caseTest("Test")
        caseTest(17.0f)
        caseTest(2)
        caseTest(null)
        // case는 이런식으로 변수형태로 구성할 수도 있다
        /*var name : String = ""
        when (name)
        {
            "A"->{}
            else->{}
        }*/

        // 이런 식으로 조건문의 결과를
        // 바로 변수의 값으로 지정할 수 있다
        var a = "ABCDE"
        var result = when(a){
            is String   -> { true }
            else        -> { false }
        }

        println(result)

        // 조건문의 결과 값이 서로 다른 자료형이여도 괜찮다
        println( if("AAA".length > 3) true else "짧아요" )

        // 결론
        // 조건문은 엄청 유연하다!
    }

    // switch-case 같은 것
    fun caseTest(o : Any?) {
        when(o) {
            "Test"          -> { println("문자 : " + o )}
            is Float        -> { println("Float : " + o )}
            in (0..9)       -> { println("0-10까지의 숫자 : $o" )}
            else            -> { println("???") }
        }
    }

    // 반복문의 다양한 형태
    fun loopTest(count : Int) {
        for( i in (0..count)) {
            println("i ->" + i)
        }

        var i : Int = 0
        while(i < count) {
            i++
            println("$i 입니다.")
        }

        (0..count).forEach { println("$it ->" + it) }
    }

    fun ifTest(a : Any?) {
        if(a == "Test") {
            println(a)
        }
        // 특정 자료형인지 체크
        else if(a is Float) {
            println("Float")
        }
        // 변수의 값이 특정 범위에 속한지 체크
        // (0..9) 이 범위 안이면 true 리턴
        // 범위에 리스트를 넣어도 된다
        else if(a in (0..9)) {
            println("0-10까지의 숫자 : $a")
        }
        else if(a == null) {
            println("null!")
        }
    }

}