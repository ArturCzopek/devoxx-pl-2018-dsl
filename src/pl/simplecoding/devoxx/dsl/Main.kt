package pl.simplecoding.devoxx.dsl

fun main(args: Array<String>) {
    val hero1Equipment = listOf(
            Item("Sword", 20),
            Item("Shield", 5),
            Item("Nike Air Max", 40)
    )
    val hero1Spells = listOf(
            Spell("Hohoho", 4)
    )

    val hero1 = Hero(
            name = "John",
            profession = Profession.KNIGHT,
            level = 20,
            equipment = hero1Equipment,
            spells = hero1Spells
    )

    val hero2Equipment = listOf(
            Item("Rod", 15)
    )
    val hero2Spells = listOf(
            Spell("Vingardium Leviosa", 20),
            Spell("Not Found", 40)
    )

    val hero2 = Hero(
            name = "Mike",
            profession = Profession.WIZARD,
            level = 25,
            equipment = hero2Equipment,
            spells = hero2Spells
    )

    val battle = Battle(hero1, hero2)

    val tournament = Tournament(
            name = "Devoxx Tournament",
            battles = listOf(battle)
    )

    println("Tournament winner: ${tournament.winner?.name ?: "NO ONE"}")
}