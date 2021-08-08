package com.platzi.market.web.security

import com.platzi.market.domain.service.PlatziUserDetailsService
import com.platzi.market.web.security.filter.JwtFilterRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var platziUserDetailsService: PlatziUserDetailsService

    @Autowired
    lateinit var jwtFilterRequest: JwtFilterRequest

    @Override
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(platziUserDetailsService)
    }

    @Override
    override fun configure(http: HttpSecurity?) {
        http!!.csrf().disable().authorizeRequests().antMatchers("/**/authenticate").permitAll()
                .anyRequest().authenticated().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter::class.java)

    }

    @Override
    @Bean
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }
}