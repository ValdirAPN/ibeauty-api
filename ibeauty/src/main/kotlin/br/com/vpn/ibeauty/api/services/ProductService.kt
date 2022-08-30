package br.com.vpn.ibeauty.api.services

import br.com.vpn.ibeauty.domain.model.Product
import br.com.vpn.ibeauty.domain.repository.ProductRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(
    private val repository: ProductRepository
) {

    fun add(product: Product) : Product {
        return repository.save(product)
    }

    fun findByStoreId(storeId: UUID) : List<Product> {
        return repository.findByStoreId(storeId)
    }
}