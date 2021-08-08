package com.platzi.market.domain.dto

class AuthenticationResponse {

    var jwt : String = ""

    constructor(jwt: String) {
        this.jwt = jwt
    }



}