package br.com.vpn.ibeauty.api.controller

import br.com.vpn.ibeauty.api.dto.UserFormDTO
import br.com.vpn.ibeauty.api.dto.UserResponseDTO
import br.com.vpn.ibeauty.api.services.UserService
import br.com.vpn.ibeauty.domain.model.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun list(): List<User> {
        return userService.findAll()
    }

    @PostMapping
    fun add(@RequestBody userFormDTO: UserFormDTO) : UserResponseDTO {
        val user = userFormDTO.toUser()
        val savedUser = userService.add(user)

        return savedUser.toUserResponseDTO()
    }
}