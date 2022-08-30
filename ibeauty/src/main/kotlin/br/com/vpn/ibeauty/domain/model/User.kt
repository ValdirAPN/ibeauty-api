package br.com.vpn.ibeauty.domain.model

import br.com.vpn.ibeauty.api.dto.UserResponseDTO
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table
import javax.persistence.Transient

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue
    var id: UUID?,
    var name: String,
    var birthday: Date,
    var role: UserRole
) {

    fun isNotProvider() = role.compareTo(UserRole.PROVIDER) != 0
    fun toUserResponseDTO() = UserResponseDTO(
        this.id,
        this.name
    )
}