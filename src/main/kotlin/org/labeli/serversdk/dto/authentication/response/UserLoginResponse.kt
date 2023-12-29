package org.labeli.serversdk.dto.authentication.response

import kotlinx.serialization.Serializable
import org.labeli.serversdk.UUIDSerializer
import org.labeli.serversdk.dto.Gettable
import org.labeli.swift.Identifiable
import java.util.*

@Serializable
public class UserLoginResponse: Gettable {
    public val user: UserResponse
    public val tokens: TokenResponse

    internal constructor(user: UserResponse, tokens: TokenResponse) {
        this.user = user
        this.tokens = tokens
    }

    @Serializable
    public class UserResponse: Gettable, Identifiable {
        @Serializable(UUIDSerializer::class)
        public override val id: UUID
        public val fullname: String
        public val email: String
        public val canSell: Boolean
        public val isAdmin: Boolean

        internal constructor(id: UUID, fullname: String, email: String, canSell: Boolean, isAdmin: Boolean) {
            this.id = id
            this.fullname = fullname
            this.email = email
            this.canSell = canSell
            this.isAdmin = isAdmin
        }
    }
}
