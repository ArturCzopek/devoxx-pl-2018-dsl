package pl.simplecoding.devoxx.dsl

fun main(args: Array<String>) {

    val tournament = tournament {
        name = "Devoxx Tournament"
        battles {
            knight("John") {
                level = 20
                equipment {
                    "Sword" power 20
                    "Shield" power 5
                    "Nike Air Max" power 40
                }
                spells {
                    "Hohoho" power 4
                }
            } versus wizard("Mike") {
                level = 25
                equipment {
                    "Rod" power 15
                }
                spells {
                    "Vingardium Leviosa" power 20
                    "Not Found" power 40
                }
            }
        }
    }

    println("Tournament winner: ${tournament.winner?.name ?: "NO ONE"}")
}