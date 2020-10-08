package de.terrestris.kotlin.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("test")
data class TestProperties(
    val someConfig: String
)
