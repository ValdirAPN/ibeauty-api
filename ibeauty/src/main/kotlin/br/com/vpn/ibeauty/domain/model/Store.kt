package br.com.vpn.ibeauty.domain.model

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Store(
    @Id
    @GeneratedValue
    var id: UUID,
    var name: String,
    var owner: User,
    var category: StoreCategory,
    var isHomeAttendant: Boolean,
    var services: List<Service>
) {
}