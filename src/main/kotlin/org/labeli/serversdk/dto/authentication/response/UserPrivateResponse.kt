package org.labeli.serversdk.dto.authentication.response

import kotlinx.serialization.Serializable
import org.labeli.serversdk.dto.Gettable
import org.labeli.swift.Identifiable

@Serializable
class UserPrivateResponse: Gettable, Identifiable<String> {
    override val id by ::email
    val email: String
    val canSell: Boolean
    val isAdmin: Boolean

    internal constructor(email: String, canSell: Boolean, isAdmin: Boolean) {
        this.email = email
        this.canSell = canSell
        this.isAdmin = isAdmin
    }
}