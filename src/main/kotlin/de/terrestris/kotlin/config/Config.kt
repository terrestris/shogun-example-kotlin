package de.terrestris.kotlin.config

import de.terrestris.kotlin.config.properties.TestProperties
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@ComponentScan(basePackages = ["de.terrestris.shoguncore", "de.terrestris.kotlin"])
@EnableJpaRepositories(basePackages = ["de.terrestris.shoguncore", "de.terrestris.kotlin"])
@EntityScan(basePackages = ["de.terrestris.shoguncore", "de.terrestris.kotlin"])
@EnableAutoConfiguration
@EnableConfigurationProperties(TestProperties::class)
class Config {

}

fun main(args: Array<String>) {
    SpringApplication.run(Config::class.java, *args)
}