import kotlin.math.cos
import kotlin.math.sin

fun main() {
    // write your code here
    val angleInRadians = readLine()!!.toDouble()
    println(sin(angleInRadians) - cos(angleInRadians))
}
