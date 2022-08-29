package br.com.vpn.ibeauty.domain.repository

import br.com.vpn.ibeauty.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<User, UUID> {
}