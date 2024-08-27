package com.example.kotlinboot

// run 실행 메서드
fun main() {
    Test1()
}

//컴파일 상수
// java 의 static과 동일한 느낌 main 보다 먼저 컴파일되는 변수
const val num = 20

//변수 선언
fun Test1() {
    
    //변수
    var a : Int = 1
    var b : String = "b"
    var c : Double = 0.1
    
    //상수
    val d = 10 // java 의 final 과 동일
    
    //d = 20 불가능 상수 이므로

    //java의 jsp의 jstl과 비슷하다
    //문자열 안에 ${} 사용하여 데이터를 주입할 수 있다.
    // println(a+" "+b+" "+c) 와 동일
    println("${a} ${b} ${c}")
}

//형변환
fun Test2() {
    var i = 10
    var l = 20L

    //l = i // 타입이 다르면 불가능, java는 자동 타입변환이 되지만 코틀린은 불가능
    l = i.toLong() // 직접 선언
    i = l.toInt()

    var s = "20"
    i = s.toInt()
    s = i.toString()
}