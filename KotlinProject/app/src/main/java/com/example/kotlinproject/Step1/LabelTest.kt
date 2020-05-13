package com.example.kotlinproject.Step1

import com.example.kotlinproject.TestClass

class LabelTest (p : (Any)->Unit) : TestClass(p) {
    override fun doTest() {
        ExitLoop()

        // 람다 호출
        // 그냥 lambdaReturn는 이 함수의 주소임
        println(lambdaReturn())

        (0..10).forEach {
            if(it > 3)
                return@forEach
            else println(it)
        }
    }

    fun ExitLoop() {
        // 레이블
        HereToExit@ for(i in 0..2) {
            for(j in 0..10) {
                // break시 그냥 해당하는 반복문 종료가 아니라
                // 레이블 지정으로 전체 밖으로 이동도 된다
                if(j == 5) break@HereToExit
                println("i -> $i, j -> $j")
            }
            println("j loop end")
        }
        println("i loop end")
    }

    // 람다식
    var lambdaReturn = Exit@ {
        if(true) {
            return@Exit 3
        }
        // 함수에서의 return 1000과 같은 것
        1000
    }
}
