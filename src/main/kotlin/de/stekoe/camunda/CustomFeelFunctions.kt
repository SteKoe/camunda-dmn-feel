package de.stekoe.camunda

import org.camunda.feel.interpreter.Val
import org.camunda.feel.interpreter.ValBoolean
import org.camunda.feel.interpreter.ValList
import org.camunda.feel.interpreter.ValString
import org.camunda.feel.spi.JavaFunction
import scala.collection.JavaConverters.collectionAsScalaIterable

val stringStartsWithConsonant: JavaFunction = JavaFunction(listOf("input")) { args ->
    val inputString = args.get(0) as ValString
    val listOfConsonants = listOf(
            ValString("a"),
            ValString("e"),
            ValString("i"),
            ValString("o"),
            ValString("u")
    )
    val feelList = ValList(collectionAsScalaIterable<Val>(listOfConsonants).toList())
    ValBoolean(feelList.items().contains(ValString.apply(inputString.value().substring(0, 1).toLowerCase())))
}

