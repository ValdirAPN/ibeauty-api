package br.com.vpn.ibeauty.domain.model

import br.com.vpn.ibeauty.api.dto.UserResponseDTO
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue
    var id: UUID?,
    var name: String,
    var birthday: Date,
    var role: UserRole,
) {

    fun toUserResponseDTO() = UserResponseDTO(
        this.id,
        this.name
    )
}