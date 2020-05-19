package com.example.kotlinproject.Step1

import com.example.kotlinproject.TestClass

class PolymorphTest (p : (Any)->Unit) : TestClass(p) {
    override fun doTest() {
        var obj1 = baseClass()
        obj1.f1()

        var obj2 = childClass()
        obj2.f1()
        obj2.f2()
        obj2.f2("문자열")
        obj2.f2("문자열", 100)


        var s = Student("박모씨")
        (0..99).forEach {s++}
        s.printMe()
        
        var s2 = Student("김모씨")
        s2.nScore = 50
        println("두 학생의 점수는 ${s + s2}")
    }

    // override 구현하려면 클래스, 필드 다 open으로 선언
    open class baseClass{
        open var name = "base"
        open fun f1() = println(this.toString())

        // 접근 제어자도 붙힐 수 있다
        private fun onlyMyFunc() = println("해당 클래스에서만 사용")

        constructor(){
            onlyMyFunc()
        }
    }

    class childClass : baseClass() {
        // override - 상속 받은 애 재정의
        override var name = ""
        override fun f1() = println(this.toString() + "재정의함")

        // overloading - 같은 이름, 다른 파라미터 처리
        fun f2() = println("f2")
        fun f2(s : String) = println("f2:${s}")
        fun f2(s : String, num : Int) = println("f2:${s}, ${num}")
    }

    class Student(s : String){
        var name : String = s
        var nScore : Int = 0

        // 연산자 오버로딩 - '+'
        operator fun plus(student : Student) : Int {
            return student.nScore + this.nScore
        }

        // 연산자 오버로딩 - '++'
        operator fun inc() : Student {
            this.nScore++
            return this
        }

        fun printMe() = println("${name}는 점수가 ${nScore}")
    }
}