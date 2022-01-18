import java.math.BigInteger

fun main() {
    // write your code here
    val (a, b) = Array(2) { readLine()!!.toBigInteger() }
    println(leastCommonMultiple(a, b))
}

fun leastCommonMultiple(a: BigInteger, b: BigInteger): BigInteger {
    return a.multiply(b).divide(a.gcd(b))
}
