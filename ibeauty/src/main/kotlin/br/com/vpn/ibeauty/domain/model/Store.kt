package br.com.vpn.ibeauty.domain.model

import br.com.vpn.ibeauty.api.dto.StoreResponseDTO
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Entity
class Store(
    @Id
    @GeneratedValue
    var id: UUID?,
    var name: String,
    @OneToOne
    var owner: User,
    var category: StoreCategory,
    var isHomeAttendant: Boolean,
    @OneToMany
    var services: List<Service>
) {

    fun toStoreResponseDTO() = StoreResponseDTO(
        id,
        name
    )
}