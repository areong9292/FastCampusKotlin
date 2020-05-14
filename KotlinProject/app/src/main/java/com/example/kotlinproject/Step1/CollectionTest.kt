package com.example.kotlinproject.Step1

import com.example.kotlinproject.TestClass

class CollectionTest (p : (Any)->Unit) : TestClass(p) {
    override fun doTest() {
        // listOf - 읽기 전용
        // 다양한 타입을 한 리스트에 넣을 수 있다
        val lst = listOf(1, "A", 12.00f, false, true)
        
        // 이런 식으로 제네릭을 하면 그 타입만 넣을 수 있다
        // val lst = listOf <Int>(1, "A", 12.00f, false, true)

        // 리스트 요소 하나씩 출력
        for (i in 0..lst.size - 1) {
            println(lst.get(i))
        }

        println(">")

        var lstEditable = mutableListOf<String>()

        lstEditable.add("A")
        lstEditable.add("B")
        lstEditable.add("C")
        lstEditable.add("D")

        for(s in lstEditable) {
            println(s)
        }

        println(">")

        // 첫번째 것 지움
        lstEditable.removeAt(0)

        for(s in lstEditable) {
            println(s)
        }

        // key value pair 해시맵
        // "A" to 1 - "A"가 키, 1이 값
        var m = hashMapOf("A" to 1, "B" to 2)
        println(m["A"].toString())
    }
}