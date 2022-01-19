import kotlin.random.Random

private const val DIE_FACES_PLUS_1 = 7

fun throwD6(): Int {
    // write your code here
    val numberOnTheDice = Random.nextInt(1, DIE_FACES_PLUS_1)
    return numberOnTheDice
}
