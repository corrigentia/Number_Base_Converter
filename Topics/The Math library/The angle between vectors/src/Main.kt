import kotlin.math.acos
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

private const val SUM_OF_ANGLES_IN_TRIANGLE = 180
private const val PI = 3.14

fun main() {
    // put your code here
    val (vectorU, vectorV) = Array(2) { readLine()!!.split(" ").map { it.toDouble() } }
    val (u1, u2) = vectorU
    val (v1, v2) = vectorV
    val lengthOfVectorU = sqrt(u1.pow(2) + u2.pow(2))
    val lengthOfVectorV = sqrt(v1.pow(2) + v2.pow(2))
    val scalarDotProductOfVectors = u1 * v1 + u2 * v2
    val cosOfAngleBetweenVectors = scalarDotProductOfVectors / (lengthOfVectorU * lengthOfVectorV)
    val angleBetweenVectors = (acos(cosOfAngleBetweenVectors) / PI * SUM_OF_ANGLES_IN_TRIANGLE).roundToInt()
    println(angleBetweenVectors)
}
