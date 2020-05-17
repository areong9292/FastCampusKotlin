package com.example.kotlinproject.Step1

import com.example.kotlinproject.TestClass
import java.io.File
import java.io.PrintWriter

class ExceptionTest (p : (Any)->Unit) : TestClass(p){
    override fun doTest() {
        var divNumber = 0
        // 707 / divNumber
        // 코틀린은 try - catch은 선택이다...?
        /*
        try{
            707 / divNumber
        } catch (e : Exception) {
            println(e)
        } finally {
            println("Last")
        }
*/

        // 이 코드는 자바에서 쓰려면 무조건 try-catch를 작성해야한다(checked exception)
        // 코틀린은 안해도 에러 안남
        // val f = File("")
        // val pw = PrintWriter(f)

        var addNumber : Int? = null
        
        // 이렇게만 하면 에러난다
        // var sum = addNumber + 100
        
        // 로직적으로 에러 체크가 들어가면 에러 안난다 - 코틀린의 강점
        if(addNumber != null)
        {
            var sum = addNumber + 100
        }

        // !! - null이면 NullPointException 출력 후 프로그램 종료
        // var sum = addNumber!! + 100

        // null일 경우 실행안됨
        var sum = addNumber?.let {
            it + 100
        }
    }
}