package com.example.kotlinproject.Step2

import com.example.kotlinproject.TestClass

class ClassTest (p : (Any)->Unit) : TestClass(p){
    override fun doTest() {
        Test1().showInfo()
        Test1("PSW", 50).showInfo()

        Test2("나다").showInfo()
        Test1("PSW", 50).showInfo()

        ChildClass("Hi").sayHello()
    }

    // 생성자 비교 클래스 Test1, Test2
    class Test1{
        var sName : String = "Test1"
        var nAge : Int = 10

        // 생성자
        constructor(){
            println(this.toString())
        }

        // 초기 값 셋팅 생성자
        constructor(name : String, age : Int){
            sName = name
            nAge = age
        }

        // 메소드
        fun showInfo () = println("${sName} : ${nAge}")
    }

    // 클래스 선언 시 함수 선언하듯이(name : String) 정의가능
    // 생성자를 선언하면서 클래스도 선언하는 것이다
    class Test2(name : String) {
        var sName : String = "Test2"
        var nAge : Int = 10

        // 받은 name으로 매개변수 셋팅
        // 주로 변수 초기화 시 사용
        init {
            sName = name
        }

        // 다른 생성자 호출하려면 : 붙힌 후 생성자 적는다
        // 처음 생상자를 클래스 이름(name)으로 지정해서 this(name)
        constructor(name : String, age : Int) : this(name) {
            sName = name
            nAge = age
        }

        // 메소드
        fun showInfo () = println("${sName} : ${nAge}")
    }

    // 상속을 시키려면(이 클래스가 부모 클래스가 되려면) open으로 정의해야한다
    open class ParentClass(msg : String) {
        var message = msg;
        fun sayHello() = println(message)
    }

    // 클래스 상속
    class ChildClass(m : String) : ParentClass(m) {

    }
}
