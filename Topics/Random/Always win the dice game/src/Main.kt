import kotlin.random.Random

private const val SEVEN = 7

fun createDiceGameRandomizer(n: Int): Int {
    // write your code here
    var friendSum = 0
    var ownSum = 0
    var seed: Int
    do {
        seed = Random.nextInt()
        val randomGenerator = Random(seed)
        repeat(n) {
            friendSum += randomGenerator.nextInt(1, SEVEN)
        }
        repeat(n) {
            ownSum += randomGenerator.nextInt(1, SEVEN)
        }
        if (ownSum > friendSum) {
            return seed
        } else {
            friendSum = 0
            ownSum = 0
        }
    } while (friendSum >= ownSum)
    return seed
}
