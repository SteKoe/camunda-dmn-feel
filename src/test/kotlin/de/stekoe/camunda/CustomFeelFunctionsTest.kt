package de.stekoe.camunda

import org.camunda.feel.interpreter.ValBoolean
import org.camunda.feel.interpreter.ValString
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class CustomFeelFunctionsTest {
    @Test
    fun `Postive case for stringStartsWithConsonant`() {
        val stringThatStartsWithConsonant = ValString("Another one bites the dust")
        val actual = stringStartsWithConsonant.function.apply(listOf(stringThatStartsWithConsonant, ValString("2"))) as ValBoolean
        assertTrue(actual.value())
    }

    @Test
    fun `Negative case for stringStartsWithConsonant`() {
        val stringThatDoesNotStartWithConsonant = ValString("The quick brown fox")
        val actual = stringStartsWithConsonant.function.apply(listOf(stringThatDoesNotStartWithConsonant)) as ValBoolean
        assertFalse(actual.value())
    }
}
