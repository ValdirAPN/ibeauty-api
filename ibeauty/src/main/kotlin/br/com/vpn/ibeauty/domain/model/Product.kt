package br.com.vpn.ibeauty.domain.model

import com.fasterxml.jackson.annotation.JsonBackReference
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Product(
    @Id
    @GeneratedValue
    var id: UUID?,
    var name: String,
    var price: Double,
    @ManyToOne
    @JsonBackReference
    var store: Store
) {
}