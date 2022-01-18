import java.math.BigInteger

fun main() {
    // write your code here
    val (a, b) = MutableList(2) { readLine()!!.toBigInteger() }
    val max = (a + b + (a - b).abs()) / BigInteger.TWO
    println(max)
}
