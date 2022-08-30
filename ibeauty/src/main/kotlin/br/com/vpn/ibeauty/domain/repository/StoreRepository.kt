package br.com.vpn.ibeauty.domain.repository

import br.com.vpn.ibeauty.domain.model.Store
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface StoreRepository : JpaRepository<Store, UUID> {

    fun findByOwnerId(id: UUID?) : Store?
}