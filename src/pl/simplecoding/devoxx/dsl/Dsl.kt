package pl.simplecoding.devoxx.dsl

fun tournament(block: TournamentBuilder.() -> Unit): Tournament = TournamentBuilder().apply(block).build()

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
