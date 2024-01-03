package org.labeli.serversdk.dto.authentication.response

import kotlinx.serialization.Serializable
import org.labeli.serversdk.dto.Gettable
import org.labeli.swift.Identifiable

@Serializable
class ClientPrivateResponse: Gettable, Identifiable<String> {
    override val id by ::email
    val email: String
    val fullname: String
    val isMember: Boolean

    internal constructor(email: String, fullname: String, isMember: Boolean) {
        this.email = email
        this.fullname = fullname
        this.isMember = isMember
    }
}