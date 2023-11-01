package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var right = 0;
    var wrong = 0;
    for (t in guess){
        if (t in secret){
            if (guess.indexOf(t) == secret.indexOf(t)){
                right ++
            }else{
                wrong ++
            }
        }
    }
    return Evaluation(right, wrong)
}
