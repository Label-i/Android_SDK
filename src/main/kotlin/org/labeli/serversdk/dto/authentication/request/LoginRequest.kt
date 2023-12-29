package org.labeli.serversdk.dto.authentication.request

import kotlinx.serialization.Serializable
import org.labeli.serversdk.dto.Postable
import org.labeli.serversdk.extensions.clone
import java.util.*

@Serializable
internal class LoginRequest: Postable {
    private val email: String
    private val password: String

    internal constructor(email: String, password: String) {
        this.email = email
        this.password = password
    }

    override fun equals(other: Any?): Boolean =
        (other is LoginRequest) &&
                email == other.email &&
                password == other.password

    override fun hashCode(): Int =
        Objects.hash(email, password)

    override fun toString(): String =
        "LoginRequest(email: $email, password: $password)"

    override fun clone(): LoginRequest =
        LoginRequest(email.clone(), password.clone())
}
