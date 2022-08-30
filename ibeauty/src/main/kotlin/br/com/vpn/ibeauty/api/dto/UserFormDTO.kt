package br.com.vpn.ibeauty.api.dto

import br.com.vpn.ibeauty.domain.model.User
import br.com.vpn.ibeauty.domain.model.UserRole
import java.util.*

data class UserFormDTO(
    val name: String,
    val birthday: Date,
    val role: UserRole,
) {
    fun toUser() = User(
        id = null,
        name = this.name,
        birthday = this.birthday,
        role = this.role,
        store = null
    )
}

