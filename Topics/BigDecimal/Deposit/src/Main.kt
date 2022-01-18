import java.math.BigDecimal
import java.math.RoundingMode

private const val THREE = 3

fun main() {
    // write your code here
    // hyperskill-12543-test-04
    /*
4567898765436782.43256489
40
15
     */
    val (startingAmount, interestRate, years) = Array(THREE) { readLine()!!.toBigDecimal() }
    val finalAmount =
        startingAmount * (
            BigDecimal.ONE + interestRate.setScale(2, RoundingMode.CEILING) / BigDecimal.TEN.multiply(
                BigDecimal.TEN
            )
            ).pow(years.toInt())
    println("Amount of money in the account: ${finalAmount.setScale(2, RoundingMode.CEILING)}")
}
