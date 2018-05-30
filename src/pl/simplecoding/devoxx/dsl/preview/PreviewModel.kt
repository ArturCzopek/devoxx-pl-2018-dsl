package pl.simplecoding.devoxx.dsl.preview

import pl.simplecoding.devoxx.dsl.Battle
import pl.simplecoding.devoxx.dsl.Hero
import pl.simplecoding.devoxx.dsl.Item
import pl.simplecoding.devoxx.dsl.Spell


private enum class Profession(val label: String) {
    KNIGHT("Knight"),
    WIZARD("Wizard");
}


private data class Hero(
        val name: String, val profession: pl.simplecoding.devoxx.dsl.Profession, var level: Int,
        val equipment: List<Item>, val spells: List<Spell>, val power: Double
)

private class Item(val name: String, val power: Int)

private class Spell(val name: String, val power: Int)

private class Battle(private val hero1: Hero, private val hero2: Hero, val winner: Hero)

private class Tournament(val name: String, val battles: List<Battle>, val winner: Hero)
