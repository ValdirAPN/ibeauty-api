package br.com.vpn.ibeauty.domain.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User(
    @Id
    @GeneratedValue
    var id: UUID,
    var name: String,
    var birthday: Date,
    var role: UserRole,
) {
}