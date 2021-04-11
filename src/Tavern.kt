import kotlin.math.roundToInt
import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 10
val patronList = mutableListOf("Eli", "Mordok", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
        .readText()
        .split("\n")
val readOnlyPatronList = patronList.toList()
fun main(args: Array<String>) {
/**   var beverage = readLine()
//beverage = null
    if (beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("I can't do that without crashing - beverage was null!")
    }
    val beverageServed: String = beverage ?: "Buttered Ale"
   println(beverageServed)*/
    //placeOrder("Shandy, Dragon's Breath, 5.91")

    /**if(patronList.contains("Eli")){
        println("The tavern master says: Eli's in the back playing cards.")
    } else {
        println("The tavern master says: Eli isn't here.")
    }
    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else {
        println("The tavern master says: Nay, they departed hours ago.")
    }*/

    (0..9).forEach{
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }

    println(uniquePatrons)

        var orderCount = 0
        while (orderCount <= 9) {
            placeOrder(uniquePatrons.shuffled().first(),
                    menuList.shuffled().first())
            orderCount++
        }

}
fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")
    val remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}
fun displayBalance(){
    println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
}

private fun placeOrder(patronName: String, menuList: String){
    val indexofApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexofApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")
    val (type, name, price)  = menuList.split(',')
    val message = "$patronName buys a $name ($type) for $price."
    println(message)
   // performPurchase(price.toDouble())
//    val phrase ="Ah,delicious $name"
//    println("Madrigal exclaims: ${toDragonSpeak(phrase)}")
    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "$patronName says: Thanks for the $name."
    }
    println(phrase)
}
private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")){
        when (it.value){
            "a" -> "4"
            "e" -> "3"
            "i" -> "2"
            "o" -> "1"
            "u" -> "|_|"
            else -> it.value
        }
    }
private fun viewMenu(){
    println("* * * Welcome to $TAVERN_NAME * * *")
}

