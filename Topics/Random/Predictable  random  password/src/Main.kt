import kotlin.random.Random

private const val TEN = 10
private const val THIRTY_THREE = 33
private const val HUNDRED_TWENTY_SEVEN = 127

fun generatePredictablePassword(seed: Int): String {
    var randomPassword = ""
    // write your code here
    val randomGenerator33to126 = Random(seed)
    repeat(TEN) {
        val randomChar = randomGenerator33to126.nextInt(THIRTY_THREE, HUNDRED_TWENTY_SEVEN)
        randomPassword += randomChar.toChar()
    }
    return randomPassword
}
