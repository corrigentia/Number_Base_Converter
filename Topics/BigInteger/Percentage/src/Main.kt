import java.math.BigInteger

fun main() {
    // write your code here
    val (firstNum, secondNum) = Array(2) { readLine()!!.toBigInteger() }
    println("${percentageOfWhenSummedWith(firstNum, secondNum)}% ${percentageOfWhenSummedWith(secondNum, firstNum)}%")
}

fun percentageOfWhenSummedWith(firstNum: BigInteger, secondNum: BigInteger): BigInteger {
    return firstNum.multiply(BigInteger.TEN.multiply(BigInteger.TEN)).divide(firstNum.add(secondNum))
}
