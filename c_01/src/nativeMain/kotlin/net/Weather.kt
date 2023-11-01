package net

class Weather {
    fun updateWeather(degrees: Int) {
//        val description: String
//        val color: Color
//        if (degrees < 10) {
//            description = "cold"
//            color = Color.BLUE
//        } else if (degrees < 25) {
//            description = "mild"
//            color = Color.ORANGE
//        } else {
//            description = "hot"
//            color = Color.RED
//        }

        //more kotlin style:
        //pair olarak initialize edilerbilirler
//        val (description: String, color: Color) =
//        if (degrees < 10) {
//             Pair("cold",Color.BLUE)
//        } else if (degrees < 25) {
//            Pair("mild",Color.ORANGE)
//        } else {
//            Pair("hot",Color.RED)
//        }
//       println("Wheater: $description ${color.name}")

        //simdi degisken turlerinin kendi tesbit edebilir
//        val (description, color) =
//            if (degrees < 10) {
//                Pair("cold",Color.BLUE)
//            } else if (degrees < 25) {
//                Pair("mild",Color.ORANGE)
//            } else {
//                Pair("hot",Color.RED)
//            }
//        println("Wheater: $description ${color.name}")

//        //if yerine when kullanalim
//        val (description, color) = when {
//            degrees < 10 ->Pair("cold", Color.BLUE)
//            degrees < 25 ->Pair("mild", Color.ORANGE)
//            else -> Pair("hot", Color.RED)
//        }
//        println("Wheater: $description ${color.name}")

        //pair yerine to kullanalim
        val (description, color) = when {
            degrees < 10 -> "cold" to Color.BLUE
            degrees < 25 -> "mild" to Color.ORANGE
            else -> "hot" to Color.RED
        }
        println("Wheater: $description ${color.name}")
    }
}

internal enum class Color {
    BLUE,
    RED,
    ORANGE
}