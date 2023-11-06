package nicestring

fun String.isNice(): Boolean {
    var text = this;
//    val first = !contains("bu")
//            && !contains("ba")
//            && !contains("be")
//    val first = setOf("ba", "be", "bu").all {!this.contains(it)}
    val first = setOf("ba", "be", "bu").none { this.contains(it) }

//    val second = count {
//        it == 'a'
//                || it == 'e'
//                || it == 'i'
//                || it == 'u'
//                || it == 'o'
//    } > 2
//    val second = count { it in setOf('a', 'e', 'i', 'o', 'u') } >= 3
    val second = count { it in "aeiou" } >= 3

//    val third = any {
//        val index = text.indexOf(it)
//        if (index == this.length - 1) false
//        else {
//            text = text.replaceRange(index, index + 1, "_")
//            val ch = text[index + 1]
//            it == ch
//        }
//    }
//    val third = (0 until lastIndex).any{this[it] == this[it+1]}
//    val third = zipWithNext().any{it.first == it.second}
    val third = windowed(2).any { it[0] == it[1] }

//    return first && second || first && third || second && third
    return listOf(first, second, third).count { it } >=2
}

fun main() {
    val s = "meraba televole"
    val s1 = s.groupBy { it }
    val s2 = s1.filter {
        it.key == 'a'
                || it.key == 'e'
                || it.key == 'i'
                || it.key == 'u'
    }
    val b = s[0]
    var total = 0

    val s3 = s2.forEach { t, u -> total += u.size }
    println(total)
}