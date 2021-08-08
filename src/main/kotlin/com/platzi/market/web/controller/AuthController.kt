package com.platzi.market.web.controller

import com.platzi.market.domain.dto.AuthenticationRequest
import com.platzi.market.domain.dto.AuthenticationResponse
import com.platzi.market.domain.service.PlatziUserDetailsService
import com.platzi.market.web.security.JWTUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController {

    @Autowired
    lateinit var authenticationManager : AuthenticationManager

    @Autowired
    lateinit var platziUserDetailsService: PlatziUserDetailsService

    @Autowired
    lateinit var jwtUtil: JWTUtil

    @PostMapping("/authenticate")
    fun createToken(@RequestBody request : AuthenticationRequest) : ResponseEntity<AuthenticationResponse> {
        try {
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(request.username, request.password))
            var userDetails : UserDetails = platziUserDetailsService.loadUserByUsername(request.username)
            var jwt : String = jwtUtil.generateToken(userDetails)
            return ResponseEntity(AuthenticationResponse(jwt), HttpStatus.OK)
        }catch (e : BadCredentialsException){
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }
    }

}