import kotlin.math.sqrt

private const val THREE = 3

fun main() {
    // put your code here
    val (a, b, c) = Array(THREE) { readLine()!!.toInt() }
    val perimeter = a + b + c
    val semiPerimeter = perimeter / 2.0
    val areaOfTriangle = sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c))
    println(areaOfTriangle)
}
