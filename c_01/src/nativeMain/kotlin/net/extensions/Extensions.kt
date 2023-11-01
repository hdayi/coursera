package net.extensions

val Any.javaClass: String? get() {return this::class.simpleName}

fun List<Int>.sum(): Int {
    var sum = 0;
    for(i:Int in this){
        sum += i
    }
    return sum;
}

//    fun sum(list: List<Int>): Int {
//        var result = 0
//        for (i in list) {
//            result += i
//        }
//        return result
//    }

    fun calistir() {
//        val sum = sum(listOf(1, 2, 3))
        val sum = listOf(1, 2, 3).sum()
        println(sum)    // 6
    }
class Extensions {

    public fun standardCollections(){
        val set = hashSetOf(1,7,53)
        val list = arrayListOf(1,7,53)
        val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
        println(set.javaClass)
        println(list.javaClass)
        println(map.javaClass)
    }
}