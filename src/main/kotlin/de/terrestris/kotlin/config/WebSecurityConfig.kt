package de.terrestris.kotlin.config

import de.terrestris.shogunboot.config.WebSecurityConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity

@Configuration
@Order(1)
@ComponentScan(basePackages = ["de.terrestris.shoguncore", "de.terrestris.kotlin"])
class TestWebSecurityConfig() : WebSecurityConfig() {
    override fun configure(http: HttpSecurity?) {
        http
            ?.authorizeRequests()
                ?.antMatchers(
                    "/",
                    "/auth/**"
                )
                ?.permitAll()
            ?.anyRequest()
                ?.authenticated()
            ?.and()
                ?.httpBasic()
            ?.and()
                ?.formLogin()
                    ?.loginPage("/")
                    ?.loginProcessingUrl("/auth/login")
            ?.and()
                ?.rememberMe()
                ?.key("SuPeRuNiQuErEmEmBeRmEKeY")
    }
}