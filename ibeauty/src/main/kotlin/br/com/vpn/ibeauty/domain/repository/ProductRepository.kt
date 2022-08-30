package br.com.vpn.ibeauty.domain.repository

import br.com.vpn.ibeauty.domain.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ProductRepository : JpaRepository<Product, UUID> {

    fun findByStoreId(id: UUID?) : List<Product>
}