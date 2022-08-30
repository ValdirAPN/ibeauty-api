package br.com.vpn.ibeauty.domain.exception

import java.util.*

class StoreNotFoundException(
    storeId: UUID
) : RuntimeException(
    "Store with id '$storeId' was not found."
) {

}