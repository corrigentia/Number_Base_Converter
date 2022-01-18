import java.math.BigDecimal
import java.math.RoundingMode

private const val THREE = 3

fun main() {
    // write your code here
    val (num1, num2, num3) = Array(THREE) { readLine()!!.toBigDecimal() }
    println(((num1 + num2 + num3) / BigDecimal(THREE)).setScale(0, RoundingMode.DOWN))
}
