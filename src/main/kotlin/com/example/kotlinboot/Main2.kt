package com.example.kotlinboot

/**
 *packageName    : com.example.kotlinboot
 * fileName       : Main2
 * author         : rhkdg
 * date           : 2024-08-29
 * description    : 고차함수/ 람다함수 공부
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-08-29        rhkdg       최초 생성
 */

//실행
fun main() {
    main4()
}

fun main1() {
    result(::sum)

    //람다 함수
    var c : (Int, Int) -> Unit = {s, n -> println(s+n)}
    var d = {s : String -> println(s)}
    var e = {s : String -> s}
    var f = { println("fff")}
    var g : (String) -> Unit = {println(it)} // 인자가 하나일 경우 it 키워드 사용 가능

    c(1,4)
    d("ddd")
    println(e("eee"))
    f()
    g("ggg")
}

fun main2() {
    var a = Test("test", 20000)
    a.apply {
        name = "apple $name"
        dc()
    }
    a.printName()
    
    //run 은 맨 마지막 값을 반환해줌
    var b = a.run {
        name = "apple $name"
        dc()
        "성공" // 반환값에 해당
    }

    //run 과 동일하지만 사용 법이 다름
    var c = with(a) {
        name = "apple $name"
        dc()
        "성공2" // 반환값에 해당
    }

    a.printName()
    println(b)

}

fun main3() {
    //let/also 사용법
    var price = 5000
    var a = Test("name", 20000)
    // 동일한 변수명에 대한 혼돈이 발생할 수 있는 이슈가 존재
    a.run { 
        println(price) // Test안에 price라는 변수가 있어도 우선순위에 의해 처음 선언된 price 값이 나온다.
    }

    //let/also는 이러한 문제를 방지
    a.let {
        println(price) //우선순위에 의해 제일 위에 선언된 price 값을 가져옴.
        println(it.price) // let 과 also는 it 키워드를 사용하기 떄문에 a 클래스 price 값을 가져옴.
    }
}

//더하기 함수
fun sum(a : Int, b : Int) = a+b

// fun 고차함수
// 이름: (입력받은 타입) -> (리턴 타입)
// 입력받은 타입은 여러개 선언이 가능하다.
fun result(sums: (Int, Int) -> Int) {
    println(sums(12,13))
}

// 스코프 함수
class Test(var name : String , var price : Int) {
    fun dc() {
        price -= 2000
    }
    fun printName() {
        println("${name} ${price}")
    }
}

fun main4() {
    Counter.count = 5;
    println(Counter.up())
    println(Counter.down())

    var a = TestTest3()
    TestTest3.total = 10
    a.up()
    println(TestTest3.total)

}

//Object
// 객체 하나만 필요해서 사용하는 경우 사용
object Counter {
    var count = 0;
    fun up() : Int {
        return ++count;
    }
    fun down() : Int{
        return --count;
    }
}

//Object를 클래스 안에도 선언할 수 있다.
// 역할은 Java에서 static 과 동일한 역할을 한다.
// 사용 키워드는 companion object 이다.
class TestTest3() {
    
    // java의 static int total = 0 과 동일한 역할
    companion object {
        var total = 0
    }

    fun up() {
        total++;
    }
}