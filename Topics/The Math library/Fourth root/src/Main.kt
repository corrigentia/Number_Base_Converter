import kotlin.math.pow

private const val FOUR_DOUBLE = 4.0

fun main() {
    // put your code here
    val number = readLine()!!.toDouble()
    println(number.pow(1.0 / FOUR_DOUBLE))
}
