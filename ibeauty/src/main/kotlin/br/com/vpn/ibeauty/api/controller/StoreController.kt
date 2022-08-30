package br.com.vpn.ibeauty.api.controller

import br.com.vpn.ibeauty.api.dto.ProductFormDTO
import br.com.vpn.ibeauty.api.dto.StoreFormDTO
import br.com.vpn.ibeauty.api.services.ProductService
import br.com.vpn.ibeauty.api.services.StoreService
import br.com.vpn.ibeauty.api.services.UserService
import br.com.vpn.ibeauty.domain.exception.InvalidRoleException
import br.com.vpn.ibeauty.domain.exception.StoreNotFoundException
import br.com.vpn.ibeauty.domain.exception.UserAlreadyHasStoreException
import br.com.vpn.ibeauty.domain.exception.UserNotFoundException
import br.com.vpn.ibeauty.domain.model.Store
import br.com.vpn.ibeauty.domain.model.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.websocket.server.PathParam
import kotlin.NoSuchElementException

@RestController
@RequestMapping("/stores")
class StoreController(
    private val storeService: StoreService,
    private val userService: UserService,
    private val productService: ProductService
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

    @PostMapping("/{storeId}/products")
    fun addProduct(@PathVariable storeId: UUID, @RequestBody productFormDTO: ProductFormDTO) : ResponseEntity<*> {
        return try {
            val store = storeService.findById(storeId)
            val product = productFormDTO.toProduct(store)

            val savedProduct = productService.add(product)

            val updatedStore = storeService.update(storeId, savedProduct)

            ResponseEntity.ok(updatedStore)
        } catch (e: NoSuchElementException) {
            ResponseEntity.notFound().build<Store>()
        }
    }

    @GetMapping("/{storeId}/products")
    fun listProducts(@PathVariable storeId: String) : ResponseEntity<*> {
        return try {
            val products = productService.findByStoreId(UUID.fromString(storeId))

            ResponseEntity.ok(products)
        } catch (e : Exception) {
            ResponseEntity.badRequest().body(e.message)
        }
    }
}