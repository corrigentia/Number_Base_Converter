private const val FOUR = 4

fun main() {
    // write your code here
    val (a, b, c, d) = Array(FOUR) { readLine()!!.toBigInteger() }
    println(-a * b + c - d)
}
