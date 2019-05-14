fun main(args: Array<String>) {
    print("Hello World\n")
    funkcja1()
    var main: Main = Main()
    main.x = 123
    println(main.x)
    main.F()
    main dodaj 1
    var s: String = "X = ${main.x}"
    main.x = 10
    println(s)
    println( if (true) "t" else  "f")

    var klasa = Klasa(3)
    klasa.x = 10
    println(klasa.x)
    var sil = SilniaSet()
    sil.x = 1
    println(sil.x)

    println(null)

    var a: Int? = 10
    a = null
    println(klasa)

    for (x in 10 downTo 1 step  2){
        println(x)
    }
    val l = listOf<Int>(4, 3, 2 ,1)
    var m = mapOf<Int, Int>(1 to 2, 3 to 4)
    for ((key, entry) in l.withIndex()) {
        println("key: $key entry: $entry")
    }

}

class Main {
    var x = 10 //zmienna
    var y: Double = 2.0
    val a = 10 //stala
    var string: String? = null
    fun F(): Unit {
        println("Jestem F")
        string?.length
    }

    infix fun dodaj(a: Int): Int{
        return 1
    }
}

class Klasa (var x: Int){

}

class SilniaSet{
    var x = 0
    set(value) {
        if (x < 1) field = 1
        if (value > 1) {
            field = x * value
            x = value - 1
        }
    }
}

fun funkcja1(): Unit{ // Unit to void
    print("Coś\n")
}

fun suma(a: Int, b: Int): Int {
    return a + b
}

fun iloczyn(a: Int, b: Int): Int = a + b

