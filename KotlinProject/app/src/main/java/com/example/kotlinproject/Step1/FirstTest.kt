package com.example.kotlinproject.Step1

import com.example.kotlinproject.TestClass

// p : (Any)->Unit - 아무런 입력 받고 리턴 값이 없다
class FirstTest (p : (Any)->Unit) : TestClass(p) {
    override fun doTest() {
        println("종결자(;) 없어도 에러 안남")
        // 형 선언 안해도 값 대입 시 자료형이 정해진다
        var name = 222

        // 이런 식으로 자료형 명시적으로도 가능
        var name1 : Int = 1234

        // 스트링인데 왜 널이 들어가냐!
        // var name2 : String = null
        // 널 넣으려면 이렇게 ?해야함
        var name2 : String? = null

        // 코틀린 파일은 내부적으로 class로 재구성된다

        println("var는 읽기쓰기 val는 읽기전용")
        // var는 읽기쓰기 val는 읽기전용
        val text = 1234

        // 이거 오류남 - val은 첫 할당 후 값 바꿀 수 없다
        // text = 34566

        // hiMessage가 밖에 있지만 컴파일 과정에서
        // FirstTest.kt 파일이 FirstTestKt.Class로 변환되며
        // 아래 hiMessage가 전역 변수 처럼 작동하게 된다
        println(hiMessage)
    }

    var hiMessage : String = "himessage"
}
