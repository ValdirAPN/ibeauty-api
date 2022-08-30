package br.com.vpn.ibeauty.domain.exception

class InvalidRoleException : RuntimeException(
    "This action requires a user PROVIDER role."
) {
}