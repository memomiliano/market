package com.platzi.market.domain.service

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class PlatziUserDetailsService: UserDetailsService {

    @Override
    override fun loadUserByUsername(username: String?): UserDetails {
        return User("maximiliano", "{noop}platzi", ArrayList())
    }
}