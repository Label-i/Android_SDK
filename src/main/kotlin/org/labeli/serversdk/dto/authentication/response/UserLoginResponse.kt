package org.labeli.serversdk.dto.authentication.response

import kotlinx.serialization.Serializable
import org.labeli.serversdk.UUIDSerializer
import org.labeli.serversdk.dto.Gettable
import org.labeli.swift.Identifiable
import java.util.*

@Serializable
class UserLoginResponse: Gettable {
    val user: UserResponse
    val tokens: TokenResponse

    internal constructor(user: UserResponse, tokens: TokenResponse) {
        this.user = user
        this.tokens = tokens
    }

    @Serializable
    class UserResponse: Gettable, Identifiable<UUID> {
        @Serializable(UUIDSerializer::class)
        override val id: UUID
        val fullname: String
        val email: String
        val canSell: Boolean
        val isAdmin: Boolean

        internal constructor(id: UUID, fullname: String, email: String, canSell: Boolean, isAdmin: Boolean) {
            this.id = id
            this.fullname = fullname
            this.email = email
            this.canSell = canSell
            this.isAdmin = isAdmin
        }
    }
}
