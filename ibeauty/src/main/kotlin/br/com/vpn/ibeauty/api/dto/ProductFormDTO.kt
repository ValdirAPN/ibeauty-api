package br.com.vpn.ibeauty.api.dto

import br.com.vpn.ibeauty.domain.model.Product
import br.com.vpn.ibeauty.domain.model.Store

data class ProductFormDTO(
    val name: String,
    val price: Double,
) {

    fun toProduct(store: Store) = Product(
        id = null,
        name = name,
        price = price,
        store = store
    )
}