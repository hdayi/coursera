package taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */

fun TaxiPark.findFakeDrivers(): Set<Driver> =
//birinci cizum
//    allDrivers.filter { d -> trips.none { it.driver == d } }.toSet()
//ikinci cozum
//    allDrivers.minus(trips.map { it.driver })
    //minus yerine eksi isereti kullaniablir
    allDrivers - trips.map { it.driver }
//bu benim cozum
//    allDrivers.filter {
//    it !in trips.groupBy { it.driver }
//        .keys
//}.toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */

fun aa(minTrips: Int, tp: TaxiPark): Set<Passenger> {
    if (minTrips == 0) return tp.allPassengers
    val a = tp.trips
    val b = a.map { it.passengers }
    val c = b.map { it }
    val d = c.flatMap { it.map { it } }
    val e = d.groupBy { it }
    val f = e.filter { it.value.size >= minTrips }
    val g = f.map { it.key }
        .toSet()
    print(a)
    return g;
}

fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
    //2'nin sadelestirmesi
//    allPassengers
//        .filter { p -> trips.count{p in it.passengers} >= minTrips}
//        .toSet()
//    2.cozum
//    allPassengers
//        .partition { p->
//            trips.sumBy{ t->
//                if(p in t.passengers) 1 else 0
//            } >= minTrips
//        }
//        .first
//        .toSet()

    //1'in sadesi
    trips
        .flatMap(Trip::passengers)
        .groupBy { passenger -> passenger }
        .filterValues{ it.size > minTrips }
        .keys
    //1. cozum
//    trips
//        .flatMap { it.passengers }
//        .groupBy { it }
//        .filter { it.value.size > minTrips }
//        .map { it.key }
//        .toSet()
    //bu benim cosum idi
    //aa(minTrips, this)

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun bb(tp: TaxiPark, driver: Driver): Set<Passenger> {
    val a = tp.trips
        .filter { trip -> trip.driver == driver }
        .flatMap(Trip::passengers)
        .groupBy { passenger -> passenger }
        .filterValues { group -> group.size > 1 }
        .keys
    return a
}

fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
//    Bu benim Cozum bayagi bir tutturmusum :)
    //bb(this, driver)

    //2.Coxum
    allPassengers
        .filter { p->
            trips.count { it.driver == driver && p in it.passengers } > 1
        }
        .toSet()


/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun cc(tp: TaxiPark): Set<Passenger> {
    val smart = tp.trips.filter { (it.discount ?: 0.0) > 0.0 }
        .map { it.passengers }
        .flatten()
        .groupBy { it }

    val dumb = tp.trips.filter { (it.discount ?: 0.0) == 0.0 }
        .map { it.passengers }
        .flatten()
        .groupBy { it }

    val total = smart.filter { it.value.size > (dumb[it.key]?.size ?: 0) }

    return total.keys
}

fun TaxiPark.findSmartPassengers(): Set<Passenger> {
    //benim cozum cok samca imis
    //= cc(this)
//    1.cozum
//    val pair = trips.partition { it.discount is Double }
//    val (tripsWithDiscount, tripsWithoutDiscount) = trips.partition { it.discount != null }
//    return allPassengers
//        .filter { passenger ->
//            tripsWithDiscount.count{ passenger in it.passengers } >
//                    tripsWithoutDiscount.count{ passenger in it.passengers }
//        }.toSet()

//    2. Cozum
    return allPassengers
        .associate {p ->
            p to trips.filter { t ->
                p in t.passengers
            }
        }
        .filterValues{ entry ->
            val group = entry
            val (withDiscount, withoutDiscount) = group.partition { trip -> trip.discount != null }
            withDiscount.size > withoutDiscount.size
        }
        .keys
}

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    return if (this.trips.isEmpty()) {
        null
    } else {
        val maxDuration: Int = trips.map { it.duration }.max() ?: 0
        val mapByNumberOfTrips = HashMap<Int, IntRange>()
        for (i in 0..maxDuration step 10) {
            val range = IntRange(i, i + 9)
            val numberOfTripsInThisRange = this.trips.filter { it.duration in range }.count()
            mapByNumberOfTrips[numberOfTripsInThisRange] = range
        }

        mapByNumberOfTrips[mapByNumberOfTrips.toSortedMap().lastKey()]
    }
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    if (this.trips.isEmpty()) {
        return false
    } else {
        val totalTripsCost = this.trips.map { it.cost }.sum()
        val mapCostByDriverSorted = trips
            .groupBy { it.driver }
            .mapValues { (_, trips) -> trips.sumByDouble { it.cost } }
            .toList()
            .sortedByDescending { (_, value) -> value }.toMap()

        var currentSum = 0.0
        var numberOfDrivers = 0
        for (value in mapCostByDriverSorted.values) {
            numberOfDrivers++
            currentSum += value
            if (currentSum >= (totalTripsCost * 0.8)) break
        }

        return numberOfDrivers <= (allDrivers.size * 0.2)
    }
}