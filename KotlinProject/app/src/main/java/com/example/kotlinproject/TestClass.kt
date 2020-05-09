package com.example.kotlinproject

open class TestClass(pFunc : (Any) -> Unit){

    // TestClass를 상속받았거나 그 안의 innerClass에서
    // println을 대처하기 위한 static 메소드
    companion object {
        var println : (Any) -> Unit = {}
    }

    // println 실행 시 pFunc 실행
    init {
        println = pFunc
    }

    // 3. 예제의 테스트 코드를 실행할 메소드
    open fun doTest() {}
}
