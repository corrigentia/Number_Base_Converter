import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt

private const val THREE = 3
private const val FOUR = 4

fun main() {
    // put your code here
    val (a, b, c) = Array(THREE) { readLine()!!.toDouble() }
    val x1 = (-b + sqrt(b.pow(2) - FOUR * a * c)).div(2 * a)
    val x2 = (-b - sqrt(b.pow(2) - FOUR * a * c)).div(2 * a)
    println("${min(x1, x2)} ${max(x1, x2)}")
}
