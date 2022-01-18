// import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    // write your code here
    val (power, mode) = Array(2) { readLine()!!.toInt() }
    val number = readLine()!!.toBigDecimal()
    println(number.setScale(mode, RoundingMode.FLOOR).pow(power))
}
