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
            wizard("Gandalf") {
                level = 22
                equipment {
                    "Rod" power 12
                }
                spells {
                    "BOOOM!" power 80
                }
            } versus wizard("Saruman") {
                level = 22
                equipment {
                    "Rod" power 12
                }
                spells {
                    "BOOOM!" power 80
                }
            }
            knight("Black") {
                level = 14
                equipment {
                    "Sword" power 40
                    "Shield" power 30
                    "Nike Air Max" power 40
                }
                spells {
                    "Wowowowow" power 14
                }
            } versus knight("White") {
                level = 23
                equipment {
                    "Sword" power 11
                    "Shield" power 60
                    "Nike Air Max" power 15
                }
                spells {
                    "Select * from nothing" power 4
                }
            }
            knight("Iron Man") {
                level = 17
                equipment {
                    "Sword" power 20
                    "Shield" power 5
                    "Nike Air Max" power 40
                }
            } versus wizard("Pikachu") {
                level = 19
                equipment {
                    "Rod" power 22
                }
                spells {
                    "Vingardium Leviosa" power 30
                    "Ebebebebe" power 30
                }
            }
        }
    }

    println("Tournament winner: ${tournament.winner?.name ?: "NO ONE"}")
}