package com.example.kotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinproject.Step1.PolymorphTest
import com.example.kotlinproject.Step2.ClassTest
import com.example.kotlinproject.Step2.DataClassTest
import com.example.kotlinproject.Step2.iasTest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 우리가 만든 예제들을 이곳에서 실행시킨다.
        // ::메소드 명 - 메소드의 주소를 가져와라
        // 아래의 뜻은 FirstTest에서의 println(기존 콘솔창 출력 메소드)는 writeln로 대체한다
        //doTest(FirstTest(::writeln))
        //doTest(NumberTest(::writeln))
        //doTest(StringTest(::writeln))
        //doTest(AnyTest(::writeln))
        //doTest(FunctionTest(::writeln))
        //doTest(ConditionTest(::writeln))
        //doTest(LabelTest(::writeln))
        //doTest(CollectionTest(::writeln))
        //doTest(ExceptionTest(::writeln))
        //doTest(ClassTest(::writeln))
        //doTest(PolymorphTest(::writeln))
        //doTest(iasTest(::writeln))
        doTest(DataClassTest(::writeln))
    }

    private fun doTest(o : TestClass) {
        o.doTest();
    }

    // txtMessage - activity_main에서 만든 id인데
    // 코틀린에선 이걸 자동으로 변수로 만들어줘서 변수처럼 사용할 수 있다(FindById 안해도됨)
    fun writeln( any : Any ) {
        txtMessage.text = "${txtMessage.text}${any.toString()}\n"
    }
}