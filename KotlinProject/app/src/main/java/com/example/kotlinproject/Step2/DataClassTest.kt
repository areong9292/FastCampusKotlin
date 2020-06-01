package com.example.kotlinproject.Step2

import com.example.kotlinproject.TestClass

class DataClassTest (p : (Any)->Unit) : TestClass(p) {
    override fun doTest() {
        // 일반적인 클래스 선언
        var a = A()
        a.power = 3
        a.name = "snake"

        println(a)

        // 생성자 호출하는 거 마냥 바로 값이 지정된다
        var d0 = DataA("AAA", 3)

        // 디폴트 값 넘어가고 다음 변수에 바로 값 넣을 수 있다
        var d = DataA(nLevel = 3)

        println(d0)
        println(d)

        var d3 = DataA(nLevel = 11)
        d3.job = "archer"

        println(d3)

        // 이미 할당된 값을 복사한다
        // 아래처럼 name의 값을 지정하면 그 값만 변경되서 복사된다
        var d4 = d3.copy(name = "동작구 디아블로")
        println(d4)

        // destruction 기능
        // 순서대로 값을 쪼갠다 - DataA의 name이 아래 name에 복사된다
        var (name) = d4
        println(name)

        // name2에 name, power에 nLevel
        var (name2, power) = d4
        println("$name2 $power")
    }

    class A {
        var name : String = ""
        var power : Int = 0
    }

    // data class - 데이터 다루는 데 특화된 클래스
    // data class는 함수마냥 선언하면서 바로 생성자 지정
    data class DataA(var name : String = "이름 없음", var nLevel : Int) {
        var job : String = ""

        // 주로 연산자 오버로딩 목적으로 자주 쓴다...?
        operator fun plus (d : DataA) {
            this.nLevel + d.nLevel
        }
    }
}

