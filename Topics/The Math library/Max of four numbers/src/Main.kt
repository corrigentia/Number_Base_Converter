import kotlin.math.max

private const val FOUR = 4

fun main() {
    // write your code here
    val (firstNum, secondNum, thirdNum, fourthNum) = Array(FOUR) { readLine()!!.toInt() }
    val greatestOfFirst2Numbers = max(firstNum, secondNum)
    val greatestOfFirst3Numbers = max(greatestOfFirst2Numbers, thirdNum)
    val greatestOfFirst4Numbers = max(greatestOfFirst3Numbers, fourthNum)
    println(greatestOfFirst4Numbers)
}
