// import java.math.BigDecimal

private const val THREE = 3

fun main() {
    // write yor code here
    val (dwalin, balin, thorin) = Array(THREE) { readLine()!!.toBigDecimal() }
    val totalGold = dwalin.add(balin.add(thorin))
    println(totalGold)
}
