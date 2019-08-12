package de.stekoe.camunda

import org.camunda.feel.spi.JavaFunction
import org.camunda.feel.spi.JavaFunctionProvider
import java.util.*
import kotlin.collections.HashMap

class CustomFeelFunctionProvider : JavaFunctionProvider() {
    override fun resolveFunction(functionName: String): Optional<JavaFunction> {
        return Optional.ofNullable(functions.get(functionName))
    }

    companion object {
        private val functions = HashMap<String, JavaFunction>()

        init {
            functions.put("stringStartsWithConsonant", stringStartsWithConsonant)
        }
    }
}

