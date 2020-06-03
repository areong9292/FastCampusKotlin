package com.example.kotlinproject.Step2

import com.example.kotlinproject.TestClass


class ObjectTest (p : (Any)->Unit) : TestClass(p) {
    override fun doTest() {
        // 1. 클래스 전체를 싱글톤으로 사용
        SingleTon.showMessage("싱글톤입니다.");

        // 이건 그냥 직접 멤버변수 접근
        var obj = StaticTest()
        println(obj.msg)

        // 2. companion object - 안의 static 변수, 함수 접근
        println(StaticTest.staticVar)
        StaticTest.staticFunc()

        // 3. Android에서 자주 사용 - 이름없는 객체를 처리할 때 사용
        var obj2 = object : fakeClickHandler() {
            override fun onClick() {
                println("Click!!")
            }
        }
        obj2.onClick()
    }

    object SingleTon {
        var showMessage = { msg : String -> println(msg) }
    }

    class StaticTest {
        var msg : String = "일반 객체로 생성하면 이 변수를 액세스 가능"

        // companion object {} 안에서 구현해야 static으로 인식되어 바로 접근 가능
        companion object {
            var staticVar = "StaticTest.staticVar"
            fun staticFunc() = println("StaticTest.staticFunc")
        }
    }

    // 누군가 객체로 만들면 onClick을 반드시 구현해야한다.
    // 이름없는 객체를 처리할 때 사용
    abstract class fakeClickHandler {
        abstract fun onClick()
    }
}
