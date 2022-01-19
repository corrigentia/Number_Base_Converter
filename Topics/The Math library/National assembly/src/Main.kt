import kotlin.math.pow
import kotlin.math.roundToInt

private const val THREE_DOUBLE = 3.0

fun main() {
    // write your code here
    val currentPopulation = readLine()!!.toDouble()
    println(currentPopulation.pow(1.0 / THREE_DOUBLE).roundToInt())
}
