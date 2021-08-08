package com.platzi.market.web.security.filter

import com.platzi.market.domain.service.PlatziUserDetailsService
import com.platzi.market.web.security.JWTUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtFilterRequest : OncePerRequestFilter() {

    @Autowired
    lateinit var jwtUtil: JWTUtil

    @Autowired
    lateinit var platziUserDetailsService: PlatziUserDetailsService

    @Override
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {

        var authorizationHeader : String? = request.getHeader("Authorization")

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
            var jwt : String = authorizationHeader.substring(7)
            var username : String? = jwtUtil.extractUsername(jwt)

            if (username != null && SecurityContextHolder.getContext().authentication == null) {
                var userDetails : UserDetails = platziUserDetailsService.loadUserByUsername(username)

                if (jwtUtil.validateToken(jwt, userDetails)) {
                    var authToken : UsernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
                    authToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                    SecurityContextHolder.getContext().authentication = authToken
                }
            }
        }

        filterChain.doFilter(request,response)

    }

}