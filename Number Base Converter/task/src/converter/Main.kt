package converter

// import java.math.BigInteger
import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode
import kotlin.math.pow

// private const val HEXADECIMAL = 16
private const val FIVE = 5
private const val NINE = 9
private const val TEN = 10
private const val DOT_CHAR = '.'
private val digits: String = (0..NINE).joinToString("")
private val upperAlphabet: String = ('A'..'Z').joinToString("")
private val digitsAndUpperLetters = digits + upperAlphabet

private fun promptBases() {
    do {
        println("Enter two numbers in the format: {source base} {target base} (To quit, type /exit) ")
        val choice = readLine()!!
        if (choice == "/exit") {
            return
        } else {
            val numberBases = choice.split(" ")
            if (numberBases.size > 1 && numberBases.first().first().isDigit() && numberBases.last().first().isDigit()) {
                val (sourceBase, targetBase) = numberBases.map { it.toInt() }
                convertFromBaseToBase(sourceBase, targetBase)
            }
        }
    } while (choice != "/exit")
}

fun convertFromBaseToBase(sourceBase: Int, targetBase: Int) {
    do {
        println("Enter number in base $sourceBase to convert to base $targetBase (To go back, type /back) ")
        val input = readLine()!!
        val hasFractionalPart = DOT_CHAR in input
        if (input == "/back") return
        else when {
            sourceBase == TEN -> convertFromDecimal(BigDecimal(input), targetBase, hasFractionalPart)
            targetBase == TEN -> println("Conversion result: ${convertToDecimal(input, sourceBase, hasFractionalPart)}")
            else -> convertFromDecimal(
                convertToDecimal(input, sourceBase, hasFractionalPart), targetBase, hasFractionalPart
            )
        }
    } while (input != "/back")
}

fun main() {
    /*
    println()
    do {
        print("Do you want to convert /from decimal or /to decimal? (To quit, type /exit) ")
        val option = readLine() // "/to" // readLine()
        println(option)
        when (option) {
            "/from" -> convertFromDecimal()
            "/to" -> convertToDecimal()
        }
    } while (option != "/exit")
    */

    /*
    println(2::class.simpleName)
    println(2 is Int)
    */
    // println(BigDecimal("23.67890").scale())
    // convertFromBaseToBase(2, 5) // 1101101110.10000 _(2) // 584.5 _(10) !!! / 878.5 _(10) ??? // 3244201.0
    promptBases()
}

private fun convertToDecimal(sourceNumber: String, sourceBase: Int, _hasFractionalPart: Boolean): BigDecimal {
    /*
    print("Enter source number: ")
    val sourceNumber = readLine()!! // "71" // readLine()!!
    println(sourceNumber)

    print("Enter source base: ")
    val sourceBase = readLine()!!.toInt() // 8 // readLine()!!.toInt()
    // println(sourceBase)
    */
    val hasFractionalPart = DOT_CHAR in sourceNumber
    val sourceInteger = integerPartOfStringNumber(sourceNumber)
    val fractionalPartOfSourceNumber = fractionalPartOfStringNumber(sourceNumber)
    var decimalRepresentation = BigDecimal.ZERO

    for (index in sourceInteger.indices) {
        val digit = sourceInteger[index].uppercaseChar()
        val digitValueInBase10 = digitsAndUpperLetters.indexOf(digit).toLong()
        val exponent = sourceInteger.length - index - 1
        decimalRepresentation = decimalRepresentation.add(
            BigDecimal(digitValueInBase10 * sourceBase.toDouble().pow(exponent).toLong())
        )
    }

    // println("decimalRepresentation: $decimalRepresentation before fraction; fractionalPartOfSourceNumber: $fractionalPartOfSourceNumber")

    if (hasFractionalPart) {
        for (index in 2..fractionalPartOfSourceNumber.lastIndex) {
            // println("index: $index")
            val digit = fractionalPartOfSourceNumber[index].uppercaseChar()
            // println("digit: $digit")
            val digitValueInBase10 = digitsAndUpperLetters.indexOf(digit).toLong()
            // println("digitValueInBase10: $digitValueInBase10")
            val exponent = (-1) * (index - 1)
            /*
            println(
                "exponent: $exponent; \n" +
                        "decimalRepresentation before adding: $decimalRepresentation; \n" +
                        "sourceBase: $sourceBase; \n" +
                        "sourceBase ^ exponent: ${
                    sourceBase.toDouble().pow(exponent)
                }; \n" +
                        "digitValueInBase10 * sourceBase.toDouble().pow(exponent): ${digitValueInBase10 * sourceBase.toDouble().pow(exponent)}; \n" +
                        "digitValueInBase10 * sourceBase.toDouble().pow(exponent).toString(): ${(digitValueInBase10 * sourceBase.toDouble().pow(exponent)).toString()}; \n" +
                        "BigDecimal(digitValueInBase10 * sourceBase.toDouble().pow(exponent).toString()): ${BigDecimal((digitValueInBase10 * sourceBase.toDouble().pow(exponent)).toString())} \n"
            )
             */
            decimalRepresentation = decimalRepresentation.add(
                BigDecimal((digitValueInBase10 * sourceBase.toDouble().pow(exponent)).toString())
            )
            // println("decimalRepresentation after expected addition: $decimalRepresentation")
        }
    }
    // println("decimalRepresentation: $decimalRepresentation after fraction")

    /*
    print("Conversion to decimal result: ")
    println(decimalRepresentation.toInt())
    println()
    */
    // println("decimalRepresentation: $decimalRepresentation; hasFractionalPart: $hasFractionalPart; FIVE: $FIVE")
    return decimalRepresentation.setScale(if (hasFractionalPart) FIVE else 0, RoundingMode.DOWN)
}

private fun convertFromDecimal(base10Number: BigDecimal, targetBase: Int, _hasFractionalPart: Boolean): String {
    /*
    print("Enter number in decimal system: ")
    val base10Number = readLine()!!.toInt()
    println(base10Number)

    print("Enter target base: ")
    val targetBase = readLine()!!.toInt()
    // println(targetBase)
    */
    val base10NumberAsString = base10Number.toString()
    val hasFractionalPart = DOT_CHAR in base10NumberAsString

    val base10Integer = integerPartOf(base10Number)
    val fractionalPartOfSourceNumber = fractionalPartOf(base10Number)

    var quotient = base10Integer
    val remaindersOfIntegerPart = mutableListOf<String>()
    do {
        val targetBasePrecision = targetBase.toBigInteger()
        val (_, remainder) = quotient.divideAndRemainder(targetBasePrecision)
        val remainderString: String = digitsAndUpperLetters[remainder.toInt()].toString()
        remaindersOfIntegerPart.add(remainderString.lowercase())
        quotient = quotient.divide(targetBasePrecision)
    } while (quotient > BigInteger.ZERO)
    val integerConversionResult = remaindersOfIntegerPart.reversed().joinToString("")

    var fractionalPart = fractionalPartOfSourceNumber
    val integerRemaindersOfFractionalPart = mutableListOf<String>()
    do {
        val targetBaseBigDecimal = BigDecimal(targetBase)
        val resultingNumber = fractionalPart.multiply(targetBaseBigDecimal)

        val integerRemainder = integerPartOf(resultingNumber) // fractionalPart.remainder(targetBaseBigDecimal)
        val remainderString: String = digitsAndUpperLetters[integerRemainder.toInt()].toString()
        integerRemaindersOfFractionalPart.add(remainderString.lowercase())
        fractionalPart =
            resultingNumber - integerPartOf(resultingNumber).toBigDecimal() // fractionalPart.divide(targetBaseBigDecimal)
    } while (fractionalPart > BigDecimal.ZERO && integerRemaindersOfFractionalPart.size < 5)

    var fractionalConversionResult = integerRemaindersOfFractionalPart.joinToString("")
    while (fractionalConversionResult.length < 5) fractionalConversionResult += "0"
    val conversionResult = integerConversionResult + if (hasFractionalPart) ".$fractionalConversionResult" else ""

    print("Conversion result: ")
    println(conversionResult) // 1214 // 12E
    println()
    println("base10NumberAsString: $base10NumberAsString")
    println("hasFractionalPart: $hasFractionalPart; _hasFractionalPart: $_hasFractionalPart")

    return if (hasFractionalPart) (conversionResult + "00000").substring(
        0, conversionResult.indexOf(DOT_CHAR) + 1 + FIVE
    ) else conversionResult
}

fun fractionalPartOf(base10Number: BigDecimal): BigDecimal {
    val base10NumberAsString: String = base10Number.toString()
    return if (DOT_CHAR in base10NumberAsString) ("0." + base10NumberAsString.substring(
        base10NumberAsString.indexOf(
            DOT_CHAR
        ) + 1
    )).toBigDecimal() else BigDecimal.ZERO
}

fun integerPartOf(base10Number: BigDecimal): BigInteger {
    val base10NumberAsString: String = base10Number.toString()
    return if (DOT_CHAR in base10NumberAsString) base10NumberAsString.substring(
        0, base10NumberAsString.indexOf(DOT_CHAR)
    ).toBigInteger() else base10Number.toBigInteger()
}

fun integerPartOfStringNumber(sourceNumber: String): String {
    return if (DOT_CHAR in sourceNumber) sourceNumber.substring(
        0, sourceNumber.indexOf(DOT_CHAR)
    ) else sourceNumber
}

fun fractionalPartOfStringNumber(sourceNumber: String): String {
    return if (DOT_CHAR in sourceNumber) ("0." + sourceNumber.substring(
        sourceNumber.indexOf(
            DOT_CHAR
        ) + 1
    )) else "0"
}
