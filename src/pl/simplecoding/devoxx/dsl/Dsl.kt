package pl.simplecoding.devoxx.dsl

fun tournament(block: TournamentBuilder.() -> Unit): Tournament = TournamentBuilder().apply(block).build()

fun wizard(name: String, block: HeroBuilder.() -> Unit) = HeroBuilder()
        .apply {
            this.name = name
            this.profession = Profession.WIZARD
        }.apply(block).build()

fun knight(name: String, block: HeroBuilder.() -> Unit) = HeroBuilder()
        .apply {
            this.name = name
            this.profession = Profession.KNIGHT
        }.apply(block).build()

class TournamentBuilder {
    var name: String = ""

    private var battlesList = mutableListOf<Battle>()

    fun battles(block: Battles.() -> Unit) {
        battlesList.addAll(Battles().apply(block))
    }

    fun build() = Tournament(name, battlesList)
}

class Battles: ArrayList<Battle>() {
    infix fun Hero.versus(opponent: Hero) = add(Battle(this, opponent))
}

class HeroBuilder {
    var name = ""
    var profession = Profession.WIZARD
    var level = 0
    var equipment = mutableListOf<Item>()
    var spells = mutableListOf<Spell>()

    fun equipment(block: Items.() -> Unit) {
        equipment.addAll(Items().apply(block))
    }

    fun spells(block: Spells.() -> Unit) {
        spells.addAll(Spells().apply(block))
    }

    fun build() = Hero(name, profession, level, equipment, spells)
}

class Items: ArrayList<Item>() {
    infix fun String.power(power: Int) = add(Item(this, power))
}

class Spells: ArrayList<Spell>() {
    infix fun String.power(power: Int) = add(Spell(this, power))
}
