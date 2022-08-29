package br.com.vpn.ibeauty.domain.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class Service(
    @Id
    @GeneratedValue
    var id: UUID,
    var name: String,
    var price: Double,
    @OneToOne
    var store: Store
) {
}