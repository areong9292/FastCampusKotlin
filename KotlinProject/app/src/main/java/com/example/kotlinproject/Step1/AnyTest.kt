package com.example.kotlinproject.Step1

import com.example.kotlinproject.TestClass
import java.util.*

// Any - 동적 타입을 지원한다
// 최종 대입된 값으로 형이 결정됨
// null 허용의 경우 ?를 넣어준다

class AnyTest (p : (Any)->Unit) : TestClass(p) {
    override fun doTest() {
        // ?를 넣어야 null 허용
        var everybody : Any

        everybody = 1111
        everybody = "문자열 테스트"
        everybody = 221.01010
        everybody = 12.00f
        
        // 최종적으로 Float가 들어가서
        // everybody의 자료형은 Float가 된다

        // 변수 is 자료형 - 해당 변수의 타입이 자료형일 경우 true, 아니면 false
        if(everybody !is String)
        {
            if(everybody is Float)
            {
                println("float 입니다")
            }
        }

        // 처음 선언 시 ? 없으면 null 못 넣는다
        // everybody = null
        
        // 값 비교 방법
        println(everybody == 12.00f)
        
        // 그리고 nullable이면 해당 값이 null일 경우 널 참조 에러 잡어서 .에서 에러 발생된다
        println(everybody.equals(12.00f))

        AllPrint(123123)
        AllPrint("HI")
        AllPrint(Date())

        // Unit 형은 값이 없음을 정의하는 형
        
        // 입력 값 없고, 리턴 값도 없는 함수형 변수 선언
        var pFunc : (Unit) -> Unit
        
        // 입력은 없어도 되는데 리턴은 꼭 있어야 한다
        // var pFunc1 : () -> Unit

        // 받은 입력이 한개면 그 값은 it이다
        var pFunc2 : (String) -> Unit = { println(it) }

        pFunc2("HIHIHIHI")

        // Nothing - 익셉션 발생, 프로그램 종료 시 필요한 형
        // TODO는 협업 등을 할 때 우선 호출부만 구현하고 기능은 나중에 구현할 때 사용한다
        // 아래 TODO탭에서 확인가능
        // 리턴 값이 Nothing
        // TODO("이거 구현해야 한다 일단 실행했으니 종료합니다")
    }

    // 이런 식으로 어떤 타입이든 다 출력할 수 있는 함수 만들 때 사용
    // 는 MainActivity에 처리되어있음
    fun AllPrint(a:Any) = println(a.toString())
}