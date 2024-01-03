package org.labeli.serversdk.dto.authentication.response

import kotlinx.serialization.Serializable
import org.labeli.serversdk.UUIDSerializer
import org.labeli.serversdk.dto.Gettable
import org.labeli.swift.Identifiable
import java.util.*

@Serializable
class ClientLoginResponse: Gettable {
    val client: ClientResponse
    val tokens: TokenResponse

    internal constructor(client: ClientResponse, tokens: TokenResponse) {
        this.client = client
        this.tokens = tokens
    }

    @Serializable
    class ClientResponse: Gettable, Identifiable<UUID> {
        @Serializable(UUIDSerializer::class)
        override val id: UUID
        val fullname: String
        val email: String
        val isMember: Boolean

        internal constructor(id: UUID, fullname: String, email: String, isMember: Boolean) {
            this.id = id
            this.fullname = fullname
            this.email = email
            this.isMember = isMember
        }
    }
}
