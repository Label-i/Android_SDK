package org.labeli.serversdk.dto.authentication.request

import org.labeli.serversdk.dto.Postable
import org.labeli.serversdk.extensions.clone
import java.util.*

internal class UserRegisterRequest: Postable {
    private val fullname: String
    private val email: String
    private val password: String
    private val rePassword: String
    private val canSell: Boolean
    private val isAdmin: Boolean

    internal constructor(fullname: String, email: String, password: String, rePassword: String, canSell: Boolean, isAdmin: Boolean) {
        this.fullname = fullname
        this.email = email
        this.password = password
        this.rePassword = rePassword
        this.canSell = canSell
        this.isAdmin = isAdmin
    }

    override fun equals(other: Any?): Boolean {
        return (other is UserRegisterRequest) &&
                fullname == other.fullname &&
                email == other.email &&
                password == other.password &&
                rePassword == other.rePassword &&
                canSell == other.canSell &&
                isAdmin == other.isAdmin
    }

    override fun hashCode(): Int {
        return Objects.hash(fullname, email, password, rePassword, canSell, isAdmin)
    }

    override fun toString(): String {
        return "UserRegisterRequest(fullname: $fullname, email: $email, password: $password, rePassword: $rePassword, canSell: $canSell, isAdmin: $isAdmin"
    }

    override fun clone(): Any {
        return UserRegisterRequest(fullname.clone(),
                                   email.clone(),
                                   password.clone(),
                                   rePassword.clone(),
                                   canSell,
                                   isAdmin)
    }
}
