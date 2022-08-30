package br.com.vpn.ibeauty.domain.exception

import java.util.*

class UserNotFoundException(
    userId: UUID
) : RuntimeException(
    "User with id '$userId' was not found."
) {

}