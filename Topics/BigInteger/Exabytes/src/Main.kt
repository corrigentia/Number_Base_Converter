import java.math.BigInteger

private const val SIXTY_THREE = 63

fun main() {
    // write your code here
    val exabytes = readLine()!!.toBigInteger()
    val bits = exabytes.multiply(BigInteger.TWO.pow(SIXTY_THREE))
    println(bits)
}
