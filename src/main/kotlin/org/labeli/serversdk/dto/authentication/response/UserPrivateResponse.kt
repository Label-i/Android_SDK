package org.labeli.serversdk.dto.authentication.response

import kotlinx.serialization.Serializable
import org.labeli.serversdk.dto.Gettable

@Serializable
public class UserPrivateResponse: Gettable {
    public val email: String
    public val canSell: Boolean
    public val isAdmin: Boolean

    internal constructor(email: String, canSell: Boolean, isAdmin: Boolean) {
        this.email = email
        this.canSell = canSell
        this.isAdmin = isAdmin
    }
}