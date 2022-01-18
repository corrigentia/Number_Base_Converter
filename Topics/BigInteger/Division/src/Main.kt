fun main() {
    // write your code here
    val (a, b) = Array(2) { readLine()!!.toBigInteger() }
    val (quotient, remainder) = a.divideAndRemainder(b)
    println("$a = $b * $quotient + $remainder")
}
