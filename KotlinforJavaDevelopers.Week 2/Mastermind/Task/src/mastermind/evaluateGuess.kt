package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    TODO()
}

enum class Color{
    RED, GREEN, BLUE, ORANGE
}