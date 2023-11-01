import net.Person
import net.Weather

fun main(args:Array<String>) {
    println("Hello, Kotlin/Native!")
    val p = Person("haci", 53);
    print(p.name + " yaslandi artik. \n")
    println("${p.age} yasina geldi de geciyor")

    val w = Weather()
    w.updateWeather(15)

    val message = if (args.size >0) args[0] else "Televole"
    println("meraba $message")

}