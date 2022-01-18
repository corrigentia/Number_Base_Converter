// import java.math.BigDecimal

fun main() {
    // write your code here
    val (num1, num2) = Array(2) { readLine()!!.toBigDecimal() }
    println(num1.multiply(num2))
}
