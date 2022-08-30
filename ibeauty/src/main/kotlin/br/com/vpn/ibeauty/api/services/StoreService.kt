package br.com.vpn.ibeauty.api.services

import br.com.vpn.ibeauty.api.dto.ProductFormDTO
import br.com.vpn.ibeauty.domain.exception.InvalidRoleException
import br.com.vpn.ibeauty.domain.exception.StoreNotFoundException
import br.com.vpn.ibeauty.domain.exception.UserAlreadyHasStoreException
import br.com.vpn.ibeauty.domain.model.Product
import br.com.vpn.ibeauty.domain.model.Store
import br.com.vpn.ibeauty.domain.repository.StoreRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class StoreService(
    private val repository: StoreRepository
) {

    fun findAll() : List<Store> {
        return repository.findAll()
    }

    fun findById(storeId: UUID) : Store {
        val store = repository.findById(storeId)

        if (store.isEmpty) throw StoreNotFoundException(storeId)

        return store.get()
    }

    fun add(store: Store) : Store {
        if (store.owner.isNotProvider()) throw InvalidRoleException()

        val userAlreadyHasStore = repository.findByOwnerId(store.owner.id)

        if (userAlreadyHasStore != null) throw UserAlreadyHasStoreException()

        return repository.save(store)
    }

    fun update(storeId: UUID, product: Product) : Store {
        val store = repository.findById(storeId).get()

        store.products.add(product)

        return repository.save(store)
    }
}