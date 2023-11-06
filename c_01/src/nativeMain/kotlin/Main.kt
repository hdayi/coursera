import net.Person
import net.Weather
import net.extensions.Extensions
import net.extensions.calistir
import net.extensions.eq
import net.extensions.isEmptyOrNull

class Hero(val name: String, val age: Int, val gender: Gender?)

enum class Gender { MALE, FEMALE }

fun main(args: Array<String>) {
    val heroes = listOf(
        Hero("The Captain", 60, Gender.MALE),
        Hero("Frenchy", 42, Gender.MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, Gender.FEMALE),
        Hero("First Mate", 29, Gender.MALE),
        Hero("Sir Stephen", 37, Gender.MALE)
    )
    println(
        heroes.all { it.age < 50 }
    )
    println(heroes.any { it.gender == Gender.FEMALE })

    val mapByAge: Map<Int, List<Hero>> =
        heroes.groupBy { it.age }
    println(mapByAge)
    val (age, group) = mapByAge.maxBy { (_, group) ->
        group.size
    }!!
    println(age)

    val mapByName: Map<String, Hero> =
        heroes.associateBy { it.name }
    println(mapByName["Frenchy"]?.age)

    println("--------------------------------------------------")
    val unknownHero = Hero("Unknown", 0, null)
    println(mapByName.getOrElse("unknown") { unknownHero }.age)

    val (first, second) = heroes
        .flatMap { heroes.map { hero -> it to hero } }
        .maxBy { it.first.age - it.second.age }!!
    println(first.name)

    println("merhaba televole, ${args.getOrNull(0)}")
    calistir()
    val extension = Extensions()
    extension.standardCollections()


    val s1: String? = null
    val s2: String? = ""
    s1.isEmptyOrNull() eq true
    s2.isEmptyOrNull() eq true
    s1.isNullOrEmpty()

    val s3 = "   "
    s3.isEmptyOrNull() eq false


    fun foo(list1: List<Int?>, list2: List<Int>?) {
        list1.size
        list2?.size

        val i: Int? =
            list1.get(0)
        val j: Int? =
            list2?.get(0)
    }

//    println("Hello, Kotlin/Native!")
//    val p = Person("haci", 53)
//    print(p.name + " yaslandi artik. \n")
//    println("${p.age} yasina geldi de geciyor")
//
//    val w = Weather()
//    w.updateWeather(15)
//
//    val message = if (args.isNotEmpty()) args[0] else "Televole"
//    println("meraba $message")
//    println(
//        listOf('a', 'b', 'c')
//            .joinToString(
//                separator = "", prefix = "(", postfix = ")"
//            )
//    )
//    fun displaySeparator(character: Char = '*', size: Int = 10) {
//        repeat(size) {
//            print(character)
//        }
//    }
//    println("")
//
//    displaySeparator('3', 5)
//    println("")
//    for (ch in "abc") {
//        print(ch + 1)
//    }
//    println()
//    print("Kotlin" in "Java".."Scala")
//    print("             ")
//    print("Java" in "Kotlin".."Scala")
//    print("             ")
//    println("Kotlin" in setOf("Java", "Scala"))
//    println("--------------------------------------------------")
//    println(isValidIdentifier("name"))   // true
//    println(isValidIdentifier("_name"))  // true
//    println(isValidIdentifier("_12"))    // true
//    println(isValidIdentifier(""))       // false
//    println(isValidIdentifier("012"))    // false
//    println(isValidIdentifier("no$"))    // false
//    println("--------------------------------------------------")
}

fun isValidIdentifier(s: String): Boolean {
    if (s.isEmpty()) {
        return false
    }
    for ((i, c) in s.withIndex()) {
        if (i == 0 && c in '0'..'9') {
            return false
        }
        if (c !in 'a'..'z'
            && c !in 'A'..'Z'
            && c !in '0'..'9'
            && c != '_'
        ) {
            return false
        }

    }
    return true
}

fun max(a: Int, b: Int) = if (a > b) a else b