package pl.simplecoding.devoxx.dsl

import pl.simplecoding.devoxx.dsl.extensions.items
import pl.simplecoding.devoxx.dsl.extensions.power
import pl.simplecoding.devoxx.dsl.extensions.spellPower
import pl.simplecoding.devoxx.dsl.extensions.spells

fun main(args: Array<String>) {

    val tournament = tournament {
        name = "Devoxx Tournament"
        battles {
            Hero(
                    name = "John",
                    profession = Profession.KNIGHT,
                    level = 20,
                    equipment = items(
                            "Sword" power 20,
                            "Shield" power 5,
                            "Nike Air Max" power 40
                    ),
                    spells = spells(
                            "Hohoho" spellPower 4
                    )
            ) versus Hero(
                    name = "Mike",
                    profession = Profession.WIZARD,
                    level = 25,
                    equipment = items(
                            "Rod" power 15
                    ),
                    spells = spells(
                            "Vingardium Leviosa" spellPower 20,
                            "Not Found" spellPower 40
                    )
            )
        }
    }

    println("Tournament winner: ${tournament.winner?.name ?: "NO ONE"}")
}