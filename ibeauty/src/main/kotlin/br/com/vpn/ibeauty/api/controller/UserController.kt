package br.com.vpn.ibeauty.api.controller

import br.com.vpn.ibeauty.api.dto.UserFormDTO
import br.com.vpn.ibeauty.api.dto.UserResponseDTO
import br.com.vpn.ibeauty.domain.model.User
import br.com.vpn.ibeauty.domain.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userRepository: UserRepository
) {

    @GetMapping
    fun list(): List<User> {
        return userRepository.findAll()
    }

    @PostMapping
    fun add(@RequestBody userFormDTO: UserFormDTO) : UserResponseDTO {
        val user = userFormDTO.toUser()
        val savedUser = userRepository.save(user)

        return savedUser.toUserResponseDTO()
    }
}