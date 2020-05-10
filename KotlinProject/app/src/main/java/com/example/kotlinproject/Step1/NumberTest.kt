package com.example.kotlinproject.Step1

import com.example.kotlinproject.TestClass

// Any 형을 받는 리턴이 없는 클래스다
class NumberTest (p : (Any)->Unit) : TestClass(p) {
    override fun doTest() {
        // 숫자형 사용 시 기왕이면 자료형 적을 것
        // 안적으면 자동으로 자료형이 셋팅되어 원하는 결과가 안나올 수 있기 때문
        var doubleV : Double = 110.1111
        var floatV : Float = 110.1f
        var longV : Long = 110
        var intV : Int = 20
        var shortV : Short = 30
        var byteV : Byte = 10

        // 실제로 println을 쓰면 문자열을 출력하는데 아래처럼 그냥 작성해도
        // 타고 들어가면 안에서 toString() 해준다
        println(doubleV)
        println(floatV)
        println(intV)

        // 자료형 변환
        // 이렇게 직접 호출해줘야한다
        doubleV = intV.toDouble()
        
        // 에러는 안나지만 성공 안될거라고 명시만 됨
        // doubleV = intV as Double

        // 위랑 여기에 변수가 회색인데 안쓰면 회색으로 표기
        intV = doubleV.toInt()

        println(byteV.toString())

        // 문자를 숫자(자료형 다 됨)로 변환
        val sum = "123".toLong() + 10
        println(sum)
    }
}