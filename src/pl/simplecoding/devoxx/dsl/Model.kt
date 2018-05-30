package pl.simplecoding.devoxx.dsl

import java.util.*

enum class Profession(val label: String) {
    KNIGHT("Knight"),
    WIZARD("Wizard");
}

private const val UPGRADED_POWER_MULTIPLIER = 3
private const val DEFAULT_POWER_MULTIPLIER = 1
private const val LEVEL_MULTIPLIER = 0.5

data class Hero(
        val name: String,
        val profession: Profession,
        var level: Int,
        val equipment: List<Item>,
        val spells: List<Spell>
) {

    val power: Double
        get() = LEVEL_MULTIPLIER * level * (equipmentPower + spellPower)

    private val equipmentPower: Int by lazy {
        when {
            equipment.isEmpty() -> 0
            else -> equipment
                    .map { powerMultiplier * it.power }
                    .reduce { acc, power -> acc + power }
        }
    }

    private val spellPower: Int by lazy {
        when {
            spells.isEmpty() -> 0
            else -> spells
                    .map { spellMultiplier * it.power }
                    .reduce { acc, power -> acc + power }
        }
    }

    fun upgradeLevel() {
        level++
    }

    private val powerMultiplier: Int
        get() = if (profession == Profession.KNIGHT) UPGRADED_POWER_MULTIPLIER else DEFAULT_POWER_MULTIPLIER

    private val spellMultiplier: Int
        get() = if (profession == Profession.KNIGHT) DEFAULT_POWER_MULTIPLIER else UPGRADED_POWER_MULTIPLIER

}

data class Item(val name: String, val power: Int)

data class Spell(val name: String, val power: Int)

data class Battle(private val hero1: Hero, private val hero2: Hero) {
    val winner: Hero by lazy {
        val luckyMultiplier1 = (1..10).random()
        val luckyMultiplier2 = (1..10).random()
        fightMessage(luckyMultiplier1, luckyMultiplier2)
        (if (luckyMultiplier1 * hero1.power > luckyMultiplier2 * hero2.power) hero1 else hero2)
                .also {
                    println("""
                        |Battle winner: ${it.name}!
                        |======================================
                    """.trimMargin())
                    it.upgradeLevel()
                }
    }

    private fun fightMessage(luckyMultiplier1: Double, luckyMultiplier2: Double) {
        println("""
            |FIGHT!
            |${hero1.name}[${hero1.level}], ${hero1.profession.label} vs ${hero2.name}[${hero2.level}], ${hero2.profession.label}
            |Power: ${hero1.power} vs ${hero2.power}
            |Lucky multipliers: $luckyMultiplier1 vs $luckyMultiplier2
        """.trimMargin())
    }
}

data class Tournament(val name: String, private val battles: List<Battle>) {
    val winner: Hero? by lazy {
        var currentBattles = battles
        var winner: Hero? = null

        do {
            when {
                currentBattles.size == 1 -> {
                    println("FINAL!")
                    winner = currentBattles[0].winner
                }
                else -> {
                    println("Phrase: 1/${currentBattles.size}")
                    currentBattles = currentBattles.indices
                            .filter { it % 2 == 0 }
                            .map { Battle(currentBattles[it].winner, currentBattles[it + 1].winner) }
                }
            }
        } while (winner == null)

        winner
    }

    init {
        val powerOfTwo = battles.isNotEmpty() && battles.size and battles.size - 1 == 0
        require(powerOfTwo, { "Fights number must be a power of 2" })
    }
}

fun ClosedRange<Int>.random() =
        (Random().nextInt(endInclusive + 1 - start) + start) / 10.0
