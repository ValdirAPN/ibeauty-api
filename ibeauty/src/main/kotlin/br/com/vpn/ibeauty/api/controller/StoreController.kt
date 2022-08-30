package br.com.vpn.ibeauty.api.controller

import br.com.vpn.ibeauty.api.dto.StoreFormDTO
import br.com.vpn.ibeauty.api.services.StoreService
import br.com.vpn.ibeauty.api.services.UserService
import br.com.vpn.ibeauty.domain.exception.InvalidRoleException
import br.com.vpn.ibeauty.domain.exception.UserAlreadyHasStoreException
import br.com.vpn.ibeauty.domain.exception.UserNotFoundException
import br.com.vpn.ibeauty.domain.model.Store
import br.com.vpn.ibeauty.domain.model.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/stores")
class StoreController(
    private val storeService: StoreService,
    private val userService: UserService
) {

    @GetMapping
    fun list(): List<Store> {
        return storeService.findAll()
    }

    @PostMapping
    fun add(@RequestBody storeFormDTO: StoreFormDTO) : ResponseEntity<*> {
        return try {
            val user = userService.findById(storeFormDTO.ownerId)

            val store = storeFormDTO.toStore(user)
            val savedStore = storeService.add(store)

            ResponseEntity.ok(savedStore.toStoreResponseDTO())
        } catch (e: UserNotFoundException) {
            ResponseEntity.notFound().build<User>()
        } catch (e: InvalidRoleException) {
            ResponseEntity.badRequest().body(e.message)
        } catch (e: UserAlreadyHasStoreException) {
            ResponseEntity.badRequest().body(e.message)
        }
    }
}