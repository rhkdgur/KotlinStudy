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
//    EventPrinter().start()
//    var a = Drink()
//    a.drink()
//
//    var b : Drink = Cola()
//    b.drink()
//
//    if(b is Cola) { // instance 확인 Cola는 Drink를 상속 받기 때문에 가능
//        b.wash()
//    }
//
//    var c = b as Cola // b Drink를 Cola로 캐스팅함 c 와 b가 동시에 캐스팅 된다.
//    c.wash()
//    b.wash()
    Test14123()

}

// 옵저버(Observer) 패턴
interface EventLisner{
    fun onEvent(count : Int)
}

class Counter2(var lisner: EventLisner) {
    fun count(){
        for(i in 0..20){
            if(i % 5 == 0) {
                lisner.onEvent(i);
            }
        }
    }
}

class EventPrinter: EventLisner{
    override fun onEvent(count: Int) {
        println(count)
    }

    fun start() {
        var count = Counter2(this)
        count.count()
    }
}

//다형성
// as 는 클래스를 casting하는 역할을 한다.
open class Drink {
    var name = "음료"
    open fun drink() {
        println("drink")
    }
}

class Cola : Drink() {
    var type = "콜라"
    override fun drink() {
        println("콜라를 마신다.");
    }
    fun wash() {
        println("콜라으로 설거지 합니다")
    }
}


//Generic 제네릭
open class A {
    open fun shout() {
        println("A shout")
    }
}

class B : A (){
    override fun shout() {
        println("B shout")
    }
}

fun <T : A> funGeneric(t : T) {
    t.shout()
}

class UsingGeneric<T : A> (val t: T) {
    fun doShout() {
        t.shout()
    }
}

//Collection List
// listOf는 생성시 넣은 객체를 대체, 추가 ,삭제 못함
// mutableListOf 는 대체 , 추가 ,삭제 기능등을 지원
fun Test123 () {
    var a = listOf(1,2,3)
    var b = mutableListOf<Int>()

//    a.add 안됨.,..
    b.add(1)
    b.add(2)
    b.add(3)
}

//null 처리
fun test123() {
    var b : String? = "dd"
    println(b?:"default") // b가 만약에 null 이면 default를 출력
    println(b!!) // 어떤 값이든 널이 될 수 없음을 강조하는 것
}

//infix 함수를 연산자 처럼 사용
fun test123123() {
    println(1 minus 1)
}

// infix fun (this 에 해당하는 타입).함수이름(인자이름: 타입) : 반환 = 구문
infix fun Int.sum(x : Int) : Int = this + x

infix fun Int.minus(x : Int) : Int = this - x

//Data 클래스
//클래스에 has(), equals(), toString(), copy(), compoentX()를 자동으로 구현해주는 클래스
class a(val name : String, val id : Int)
data class b(val name : String, val id : Int)

//lateinit
//기본 자료형을 제외(String 가능)하고 객체 생성시 초기화를 하지 않고 변수만 선언할 수 있게 하는 키워드
class e {
    lateinit var a : String
    fun test() : String {
        //a가 초기화 됬는지 체크
        if(::a.isInitialized) {
            return a
        }else {
            return "null"
        }
    }
}

//lazy
//num 를 출력할 때 text.length 속성을 사용하여 7 라는 변수를 초기화 할 수 있다.
//선언부를 자세히 보면, val 로 선언이 되어있는 것을 볼 수 있다. 이는 단 한 번의 늦은 초기화가 이루어지고 이후에는 값이 불변함을 보장한다.
fun Test14123() {
    val num : Int by lazy {
        println("초기화")
        7
    }

    println("start")
    println(num)
    println(num)

}