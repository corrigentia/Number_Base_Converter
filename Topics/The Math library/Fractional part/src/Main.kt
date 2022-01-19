// import kotlin.math.*

// private const val DOT_CHAR = '.'
private const val TEN = 10

fun main() {
    // put your code here
    val number = readLine()!!.toDouble()
    /*
    val numberAsString = number.toString()
    val indexOfDotChar = numberAsString.indexOf(DOT_CHAR)
    val stringResult = numberAsString.substring(indexOfDotChar + 1, indexOfDotChar + 2)
    println(stringResult)
    */
    val intResult = (number * TEN % TEN).toInt()
    println(intResult)
}
