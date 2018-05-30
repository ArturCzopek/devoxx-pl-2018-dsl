package pl.simplecoding.devoxx.dsl.extensions

import pl.simplecoding.devoxx.dsl.Battle
import pl.simplecoding.devoxx.dsl.Hero
import pl.simplecoding.devoxx.dsl.Item
import pl.simplecoding.devoxx.dsl.Spell


fun battles(vararg battles: Battle) = battles.toList()

fun spells(vararg spells: Spell) = spells.toList()

fun items(vararg items: Item) = items.toList()

infix fun Hero.versus(opponent: Hero) = Battle(this, opponent)

infix fun String.power(power: Int) = Item(this, power)

infix fun String.spellPower(power: Int) = Spell(this, power)