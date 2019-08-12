package de.stekoe.camunda

import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin
import org.camunda.feel.CamundaFeelEnginePlugin
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CamundaConfig {
    @Bean
    fun feelScalaPlugin(): ProcessEnginePlugin = CamundaFeelEnginePlugin()
}
