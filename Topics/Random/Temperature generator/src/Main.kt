import kotlin.random.Random

private const val DAYS_IN_WEEK = 7
private const val MIN_TEMP = 20
private const val MAX_TEMP_PLUS_1 = 31

fun generateTemperature(seed: Int): String {
    // write your code here
    val randomGenerator = Random(seed)
    val listOfTemperatures = mutableListOf<Int>()
    repeat(DAYS_IN_WEEK) {
        listOfTemperatures.add(randomGenerator.nextInt(MIN_TEMP, MAX_TEMP_PLUS_1))
    }
    return listOfTemperatures.joinToString(" ")
}
