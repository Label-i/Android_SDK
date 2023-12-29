package org.labeli.serversdk.dto.authentication.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import org.labeli.serversdk.UUIDSerializer
import org.labeli.serversdk.dto.Gettable
import org.labeli.swift.Identifiable
import java.util.*

@Serializable
public class ClientLoginResponse: Gettable {
    public val client: ClientResponse
    public val tokens: TokenResponse

    internal constructor(client: ClientResponse, tokens: TokenResponse) {
        this.client = client
        this.tokens = tokens
    }

    @Serializable
    public class ClientResponse: Gettable, Identifiable {
        @Serializable(UUIDSerializer::class)
        public override val id: UUID
        public val fullname: String
        public val email: String
        public val isMember: Boolean

        internal constructor(id: UUID, fullname: String, email: String, isMember: Boolean) {
            this.id = id
            this.fullname = fullname
            this.email = email
            this.isMember = isMember
        }
    }
}
