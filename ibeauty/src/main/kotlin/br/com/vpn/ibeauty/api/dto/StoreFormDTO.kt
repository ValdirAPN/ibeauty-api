package br.com.vpn.ibeauty.api.dto

import br.com.vpn.ibeauty.domain.model.*
import java.util.UUID

data class StoreFormDTO(
    val name: String,
    val ownerId: UUID,
    val category: StoreCategory,
    val isHomeAttendant: Boolean,
) {
    fun toStore(user: User) = Store(
        id = null,
        name = name,
        owner = user,
        category = category,
        isHomeAttendant = isHomeAttendant,
        services = listOf()
    )
}
