// import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    // write your code here
    val number = readLine()!!.toBigDecimal()
    val newScale = readLine()!!.toInt()
    println(number.setScale(newScale, RoundingMode.HALF_DOWN))
}
