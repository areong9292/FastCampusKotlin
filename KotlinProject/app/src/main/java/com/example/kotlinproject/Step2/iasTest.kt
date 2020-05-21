package com.example.kotlinproject.Step2

import com.example.kotlinproject.TestClass

class iasTest (p : (Any)->Unit) : TestClass(p) {
    override fun doTest() {
        var WhatYouWant = 2
        var inter : A = if(WhatYouWant == 1) B2() else B()

        interfaceTest(inter)

        var obj2 = D();
        obj2.TestFunc()
        obj2.abstractFunc()

        println(D.staticVar)
        D.staticFunc()
    }

    fun interfaceTest(pInter : A) {
        pInter.doA()
    }

    // 이 메소드를 상속받는 애는 무조건 doA를 구현해야한다
    interface A{
        fun doA()
    }

    class B : A {
        override fun doA() = println("A InterTest")/* {
            // ctrl + o 를 누르면 interface의 메소드 선택해서 override된다
            // 그리고 안에는 아래의 TODO가 생성됨
            // 이거를 그대로 두면 앱이 TODO를 만나면 종료되서 실행 안되고 지워줘야함
            //TODO("Not yet implemented")

            println("A InterTest")
        }*/
    }

    class B2 : A{
        override fun doA() = println("A2")/* {
            println("A2")
        }*/
    }

    abstract class TestAbstract {
        fun TestFunc() = println("abstract TestFunc")
        abstract fun abstractFunc()
    }

    class D : TestAbstract() {
        // abstract로 선언했기에 반드시 override로 구현해야한다
        override fun abstractFunc() {
            //TODO("Not yet implemented")
        }

        companion object {
            var staticVar = "companion staticVar"
            fun staticFunc() = println(staticVar)
        }
    }
}