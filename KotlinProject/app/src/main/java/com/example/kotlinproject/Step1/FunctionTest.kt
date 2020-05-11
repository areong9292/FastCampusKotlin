package com.example.kotlinproject.Step1

import com.example.kotlinproject.TestClass

class FunctionTest (p : (Any)->Unit) : TestClass(p) {

    override fun doTest() {
        println(ThreeMul(1))

        funByNoParam();
        funByParameter(31, "숫자입니다")
        println(funByReturn("Parameter"))
        println(funByInline(31, 10))

        funcVar("Function Variable 1")
        println(funcVarType("Function Variable 2"))

        HigherFunc({println("Higher Function")})
        HigherFunc(::funByNoParam)
    }

    // 간단한 함수는 이런 식으로 처리가 가능하다
    fun Three() = 3
    
    // 함수에서 함수 호출 가능
    fun ThreeMul (n : Int) = Three() * n
    
    // String을 입력으로 받고 리턴은 널을 허용하는 Any다
    fun funByReturn(s : String): Any {
        return s
    }

    fun funByParameter (i : Int, s : String){
        println(i.toString() + s)
    }

    fun funByInline(i : Int, il : Int) = i * il

    fun funByNoParam()
    {
        println("funByNoParam")
    }

    // 고차함수 - 입력 값이 함수, 리턴 값이 함수인 함수
    // 아래 함수는 그냥 함수 받아서 실행시켜주는 것
    fun HigherFunc(f : () -> Unit) {
        f()
    }

    // val - 읽기 전용
    // String을 입력으로 받고 그 값을 println 하는 함수
    // 함수의 변수화
    val funcVar = {s : String -> println(s)}

    // 입력을 String으로 받고 결과가 Any?
    // :: - 함수 주소 값(함수의 포인터)을 넘긴다
    val funcVarType : (String) -> Any = ::funByReturn
}
