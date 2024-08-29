package com.example.kotlinboot

import java.util.*

// run 실행 메서드
fun main() {
   var test9 = Test9()
    test9.intro();
    test9.a = "테스트"
    println("a는 ${test9.a}");
    test9.readTextChange()
    test9.textChange("이름 변경")
    test9.readTextChange()
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

// null 표현 방식
fun Test3() {
    var a = null // 자료형을 선언하지 않을 경우 null 선언 가능
    var b : Int? = null // 자료형을 표시할 경우 ? 를 추가하지 않으면 에러 발생
    println(a)
    println(b)
}

// 배열 방식
fun Test4 () {
    var intArr = arrayOf(1,2,3,4) // intArr : Array<Int> = arrayOf(1,2,3,4)
    var intArr2 = arrayOfNulls<String>(5) // 타입이 선언될 경우 ? 표시 하지않으면 에러
    var intArr3 : Array<Any> = arrayOf(1, "a", 3.2, 4) // Any 타입은 java의 Object와 동일
    println(Arrays.toString(intArr)) // [1, 2, 3, 4]
    println(Arrays.toString(intArr2)) // [null, null, null, null, null]
    println(Arrays.toString(intArr3)) // [1, a, 3.2, 4]
}

/**
 * 기본 함수
 */
fun Test5() {
    
    // 기본형 함수
    // fun 함수이름(매개변수 : type) : 리턴 타입
    fun add1( a : Int, b: Int, c: Int): Int {
        return a + b + c
    }
    
    // 단일형 함수
    fun add2( a : Int, b: Int, c: Int) = a + b + c

    println(add1(1,2,3))
    println(add2(1,2,3))
}

//if 조건
fun Test6() {
    var a = 5

    if(a > 5) {
        println("5보다 큼")
    }else if(a > 3) {
        println("3보다 큼")
    }else {
        println("----")
    }

    //데이터 타입 비교 java의 InstanceOf 와 동일한 개념
    if(a is Int) {
       println("동일")
    }else {
       println("불일치")
    }
}

//when == switch 문
fun Test7 (a: Any) {
    when(a) {
        1 -> print(a)
        "aaa" -> print(a)
        else -> print(a)
    }

    //변수 b에 바로 선언가능 return값으로 인식하나봄
    var b = when(a) {
        1 -> a
        "aaa" -> a
        else -> a
    }

    println(b)
}

//while 문은 java와 동일
// break 와 continue는 java와 동일
fun Test8 () {
    for(i in 0..3) {
        print(i)
        print(" ")
    }

    println()
    println("----------")

    for(i in 3 downTo 0){
        print(i)
        print(" ")
    }

    println()
    println("----------")

    for(i in 0..5 step 2) {
        print(i)
        print(" ")
    }

    println()
    println("----------")

    for(i in 'a'..'e'){
        print(i)
        print(" ")
    }

    println()
    println("----------")

    var intArr = listOf(1,2,3,4,5)
    intArr.forEach{
        x ->
            print(x)
            print(" ")

    }

    println()
    println("----------")

    // @label 사용
    // label 이름을 break, continue에 달면 그 실행 결과는 라벨 기준이 된다.

    // 만약 break문에 아무것도 선언 안하는 경우
    for( i in 0..5){
        for(j in 0..5) {
            if(i == 0 && j == 3) {
                println("${i},${j}")
                break;
            }
        }
        println("i for는 계속 돔...")
    }

    println()
    println("----------")

    // 만약 parent label을 이중 포문 break에 달 경우
    parent@for( i in 0..5){
        for(j in 0..5) {
            if(i == 0 && j == 3) {
                println("${i},${j}")
                break@parent;
            }
        }
        println("i for는 계속 돔...")
    }
}

//클래스
class Test9(var d : String,var e : Int){
    var a : String = "11"
        set(value) {
            field = value
        }
        get() = field

    var b : Int = 10
        private set(value) {
            field = value
        }
        get() = field

    private var c : String = "접근제어용"

    //생성자 초기 실행 할때 사용
    init{
        println("$d, $e")
    }

    //보조 생성자
    constructor() : this("12", 15)

    fun textChange(value : String) {
        c = value
    }

    fun readTextChange() = println(c)
    

    fun intro() {
        println("$a, $b")
    }

}

//상속
// open이 아닌 abstract 추상클래스로 선언하여도 상속이 가능하다
//abstract class Sound(var name : String,var type : String) {
open class Sound(var name : String,var type : String) {
    open fun voice() {
        println("${name}과 ${type}")
    }

    fun voice2 () {
        println("${name}과 ${type}")
    }
}

//인터페이스
interface Bang{
    fun bang()
}

interface Shoot{
    fun shot(){
        println("shoo shoo shoo")
    }
}

class Test10(var name1 : String , var type1 : String) : Sound(name1,type1), Bang,Shoot{

    // 부모 클래스가 open으로 메소드를 열어두었기 떄문에 override가 가능함
    override fun voice(){
        println("${name1} 또는 ${type1}")
    }

    override fun bang() {
        println("bang 상속 가능")
    }
    
    override fun shot(){
        println("shot 상속 가능")
    }

    //에러가 발생 open을 안해줘서 override가 안됨
//    override fun voice2() {
//
//    }

}