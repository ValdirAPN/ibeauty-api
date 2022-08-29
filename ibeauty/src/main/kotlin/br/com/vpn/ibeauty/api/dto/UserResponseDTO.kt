package br.com.vpn.ibeauty.api.dto

import java.util.UUID

data class UserResponseDTO(
    val id: UUID?,
    val name: String,
) {
}