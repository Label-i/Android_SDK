package org.labeli.serversdk.dto.authentication.request

import org.labeli.serversdk.dto.Postable
import org.labeli.serversdk.extensions.clone
import java.util.*

internal class ClientRegisterRequest: Postable {
    private val fullname: String
    private val email: String
    private val password: String
    private val rePassword: String

    internal constructor(fullname: String, email: String, password: String, rePassword: String) {
        this.fullname = fullname
        this.email = email
        this.password = password
        this.rePassword = rePassword
    }

    override fun equals(other: Any?): Boolean =
        other is ClientRegisterRequest &&
                fullname == other.fullname &&
                email == other.email &&
                password == other.password &&
                rePassword == other.rePassword

    override fun hashCode(): Int =
        Objects.hash(fullname, email, password, rePassword)

    override fun toString(): String =
        "ClientRegisterRequest(fullname: $fullname, email: $email, password: $password, rePassword: $rePassword"

    override fun clone(): ClientRegisterRequest =
        ClientRegisterRequest(fullname.clone(),
                              email.clone(),
                              password.clone(),
                              rePassword.clone())
}
