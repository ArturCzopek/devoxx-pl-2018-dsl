package pl.simplecoding.devoxx.dsl

fun main(args: Array<String>) {

    val tournament = Tournament(
            name = "Devoxx Tournament",
            battles = listOf(
                    Battle(
                            Hero(
                                    name = "John",
                                    profession = Profession.KNIGHT,
                                    level = 20,
                                    equipment = listOf(
                                            Item("Sword", 20),
                                            Item("Shield", 5),
                                            Item("Nike Air Max", 40)
                                    ),
                                    spells = listOf(
                                            Spell("Hohoho", 4)
                                    )
                            ),
                            Hero(
                                    name = "Mike",
                                    profession = Profession.WIZARD,
                                    level = 25,
                                    equipment = listOf(
                                            Item("Rod", 15)
                                    ),
                                    spells = listOf(
                                            Spell("Vingardium Leviosa", 20),
                                            Spell("Not Found", 40)
                                    )
                            )
                    )
            )
    )

    println("Tournament winner: ${tournament.winner?.name ?: "NO ONE"}")
}