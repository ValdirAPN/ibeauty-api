package br.com.vpn.ibeauty.domain.exception

import java.lang.RuntimeException

class UserAlreadyHasStoreException : RuntimeException("User already has an store") {
}