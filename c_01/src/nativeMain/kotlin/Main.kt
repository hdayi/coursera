import net.Person
import net.Weather

fun main(args: Array<String>) {
    println("Hello, Kotlin/Native!")
    val p = Person("haci", 53);
    print(p.name + " yaslandi artik. \n")
    println("${p.age} yasina geldi de geciyor")

    val w = Weather()
    w.updateWeather(15)

    val message = if (args.size > 0) args[0] else "Televole"
    println("meraba $message")
    println(
        listOf('a', 'b', 'c')
            .joinToString(
                separator = "", prefix = "(", postfix = ")"
            )
    )
    max(5, 4)
    fun displaySeparator(character: Char = '*', size: Int = 10) {
        repeat(size) {
            print(character)
        }
    }
    println("")

    displaySeparator('3', 5)
    println("")
    for (ch in "abc") {
        print(ch + 1)
    }
    println()
    print("Kotlin" in "Java".."Scala")
    print("             ")
    print("Java" in "Kotlin".."Scala")
    print("             ")
    println("Kotlin" in setOf("Java", "Scala"))
    println("--------------------------------------------------")
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
    println("--------------------------------------------------")
}

fun isValidIdentifier(s: String): Boolean {
    val sonuc = false
    for ((i, c) in s.withIndex()) {
        if (i ==0 && c in '0'..'9') {return false}

    }
    return sonuc
}

fun max(a: Int, b: Int) = if (a > b) a else b