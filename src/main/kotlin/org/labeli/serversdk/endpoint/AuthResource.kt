package org.labeli.serversdk.endpoint

import org.labeli.serversdk.HTTPMethod
import org.labeli.serversdk.HTTPRequest
import org.labeli.serversdk.dto.authentication.request.ClientRegisterRequest
import org.labeli.serversdk.dto.authentication.request.LoginRequest
import org.labeli.serversdk.dto.authentication.request.RefreshTokenRequest
import org.labeli.serversdk.dto.authentication.request.UserRegisterRequest
import org.labeli.serversdk.dto.authentication.response.*
import org.labeli.serversdk.extensions.div

internal class AuthResource(path: String) {
    internal val user = UserResource(path / "user")
    internal val client = ClientResource(path / "client")

    internal inner class UserResource(private val path: String) {
        internal val getAllAdmin = HTTPRequest<List<UserPrivateResponse>>(path / "admin" / "all")
        internal val getAllSeller = HTTPRequest<List<UserPrivateResponse>>(path / "seller" / "all")
        internal val deleteMe = HTTPRequest<Unit>(path / "delete", HTTPMethod.DELETE)

        internal fun login(user: LoginRequest): HTTPRequest<UserLoginResponse> =
            HTTPRequest(path / "login", HTTPMethod.POST, body = user)

        internal fun refreshToken(token: RefreshTokenRequest): HTTPRequest<TokenResponse> =
            HTTPRequest(path / "refreshTokens", HTTPMethod.POST, body = token)

        internal fun register(user: UserRegisterRequest): HTTPRequest<Unit> =
            HTTPRequest(path / "register", HTTPMethod.POST, body = user)

        internal fun updateIsAdmin(isAdmin: Boolean, email: String): HTTPRequest<Unit> =
            HTTPRequest(path / "update" / "isAdmin" / email / isAdmin.toString(), HTTPMethod.PATCH)


        internal fun updateCanSell(canSell: Boolean, email: String): HTTPRequest<Unit> =
            HTTPRequest(path / "update" / "canSell" / email / canSell.toString(), HTTPMethod.PATCH)

        internal fun deleteByEmail(email: String): HTTPRequest<Unit> =
            HTTPRequest(path / "delete" / email, HTTPMethod.DELETE)
    }

    internal inner class ClientResource(private val path: String) {
        internal val getAllMember = HTTPRequest<ClientPrivateResponse>(path / "member" / "all")
        internal val resetMember = HTTPRequest<Void>(path / "reset" / "member", HTTPMethod.PATCH)
        internal val deleteMe = HTTPRequest<Void>(path / "delete", HTTPMethod.DELETE)

        internal fun register(client: ClientRegisterRequest): HTTPRequest<Unit> =
            HTTPRequest(path / "register", HTTPMethod.POST, body = client)

        internal fun login(client: LoginRequest): HTTPRequest<ClientLoginResponse> =
            HTTPRequest(path / "login", HTTPMethod.POST, body = client)

        internal fun refreshToken(token: RefreshTokenRequest): HTTPRequest<TokenResponse> =
            HTTPRequest(path / "refreshTokens", HTTPMethod.POST, body = token)

        internal fun updateIsMember(isMember: Boolean, email: String): HTTPRequest<Unit> =
            HTTPRequest(path / "update" / "isMember" / email / isMember.toString(), HTTPMethod.PATCH)
    }
}