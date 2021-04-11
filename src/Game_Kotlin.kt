/**fun main() {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    printPlayerStatus(auraColor, isBlessed, healthPoints, name)
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    healthPoints: Int,
    name: String
) {
    println(
        "(Aura: $auraColor) " +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
    val healthStatus = when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }
    return healthStatus
}*/
fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    var isBlessed = true
    val isImmortal= false
// Аура
val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
val healthStatus = formatHealthStatus(healthPoints, isBlessed)
// Состояние игрока
printPlayerStatus(auraColor, isBlessed, name, healthStatus)
    castFireball()
}
private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds, but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }

private fun printPlayerStatus(auraColor: String,
                              isBlessed: Boolean,
                              name: String,
                              healthStatus: String) {
    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}
private fun auraColor(isBlessed: Boolean,
                      healthPoints: Int,
                      isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}
private fun castFireball(numFireballs: Int = 2) {
   var condition = when(numFireballs){
        in 1..10 -> "Tipsy"
       in 11..20 -> "Sloshed"
       in 21..30 -> "Soused"
       in 31..40 -> "Stewed"
       else  -> "tOasT3d"
    }
    println("A glass of Fireball springs into existence. (x$numFireballs)")
    println("The Hero is $condition")

}
