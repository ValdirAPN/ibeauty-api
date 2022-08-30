package br.com.vpn.ibeauty.api.services

import br.com.vpn.ibeauty.domain.exception.UserNotFoundException
import br.com.vpn.ibeauty.domain.model.User
import br.com.vpn.ibeauty.domain.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(
    private val repository: UserRepository
) {

    fun findAll() : List<User> {
        return repository.findAll()
    }

    fun findById(userId: UUID) : User {
        val user = repository.findById(userId)

        if (user.isEmpty) throw UserNotFoundException(userId)

        return user.get()
    }

    fun add(user: User) : User {
        return repository.save(user)
    }
}