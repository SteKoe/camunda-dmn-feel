package de.stekoe.camunda

import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.camunda.bpm.engine.DecisionService
import org.camunda.bpm.engine.variable.impl.value.PrimitiveTypeValueImpl.BooleanValueImpl
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class CustomFeelFunctionsIT {
    @Autowired
    lateinit var decisionService: DecisionService

    @Test
    fun `Postive case for stringStartsWithConsonant`() {
        val context = HashMap<String, Any?>()
        context.set("SENTENCE", "Another one bites the dust")

        val decisionResult = decisionService.evaluateDecisionTableByKey("DT_DMN", context)
        assertTrue(decisionResult.getSingleEntryTyped<BooleanValueImpl>().value)
    }

    @Test
    fun `Negative case for stringStartsWithConsonant`() {
        val context = HashMap<String, Any?>()
        context.set("SENTENCE", "The quick brown fox")

        val decisionResult = decisionService.evaluateDecisionTableByKey("DT_DMN", context)
        assertFalse(decisionResult.getSingleEntryTyped<BooleanValueImpl>().value)
    }
}
