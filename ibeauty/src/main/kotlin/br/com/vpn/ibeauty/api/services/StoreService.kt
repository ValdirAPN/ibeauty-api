package br.com.vpn.ibeauty.api.services

import br.com.vpn.ibeauty.domain.exception.InvalidRoleException
import br.com.vpn.ibeauty.domain.exception.UserAlreadyHasStoreException
import br.com.vpn.ibeauty.domain.model.Store
import br.com.vpn.ibeauty.domain.repository.StoreRepository
import org.springframework.stereotype.Service

@Service
class StoreService(
    private val repository: StoreRepository
) {

    fun findAll() : List<Store> {
        return repository.findAll()
    }

    fun add(store: Store) : Store {
        if (store.owner.isNotProvider()) throw InvalidRoleException()

        val userAlreadyHasStore = repository.findByOwnerId(store.owner.id)

        if (userAlreadyHasStore != null) throw UserAlreadyHasStoreException()

        return repository.save(store)
    }
}