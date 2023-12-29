package org.labeli.serversdk.endpoint

import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.labeli.serversdk.HTTPMediaType.Application.Companion.json
import org.labeli.serversdk.HTTPMediaType.Companion.application
import org.labeli.serversdk.dto.authentication.request.ClientRegisterRequest
import org.labeli.serversdk.dto.authentication.request.LoginRequest
import org.labeli.serversdk.dto.authentication.request.RefreshTokenRequest
import org.labeli.serversdk.dto.authentication.request.UserRegisterRequest
import org.labeli.serversdk.extensions.div
import org.labeli.serversdk.extensions.patch
import org.labeli.serversdk.extensions.post

internal class AuthResource(path: String) {
    internal val user = UserResource(path / "user")
    internal val client = ClientResource(path / "client")

    internal inner class UserResource(private val path: String) {
        internal val getAllAdmin = Request.Builder()
                                          .url(path / "admin" / "all")
                                          .get()
                                          .build()

        internal val getAllSeller = Request.Builder()
                                           .url(path / "seller" / "all")
                                           .get()
                                           .build()

        internal val deleteMe = Request.Builder()
                                       .url(path / "delete")
                                       .delete()
                                       .build()

        // TODO: Convert to json
        internal fun login(user: LoginRequest): Request =
            Request.Builder()
                   .url(path / "login")
                   .post(user.toString(), application(json))
                   .build()

        internal fun refreshToken(token: RefreshTokenRequest): Request =
            Request.Builder()
                   .url(path / "refreshTokens")
                   .post(token.toString(), application(json))
                   .build()

        internal fun register(user: UserRegisterRequest): Request =
            Request.Builder()
                   .url(path / "register")
                   .post(user.toString(),application(json))
                   .build()

        internal fun updateIsAdmin(isAdmin: Boolean, email: String): Request =
            Request.Builder()
                   .url(path / "update" / "isAdmin" / email / isAdmin.toString())
                   .patch()
                   .build()

        internal fun updateCanSell(canSell: Boolean, email: String): Request =
            Request.Builder()
                   .url(path / "update" / "canSell" / email / canSell.toString())
                   .patch()
                   .build()

        internal fun deleteByEmail(email: String): Request =
            Request.Builder()
                   .url(path / "delete" / email)
                   .delete()
                   .build()
    }

    internal inner class ClientResource(private val path: String) {
        internal val getAllMember = Request.Builder()
                                           .url(path / "member" / "all")
                                           .get()
                                           .build()

        internal val resetMember = Request.Builder()
                                          .url(path / "reset" / "member")
                                          .patch()
                                          .build()

        internal val deleteMe = Request.Builder()
                                       .url(path / "delete")
                                       .delete()
                                       .build()

        internal fun register(client: ClientRegisterRequest): Request =
            Request.Builder()
                   .url(path / "register")
                   .post(client.toString(), application(json))
                   .build()

        internal fun login(client: LoginRequest): Request =
            Request.Builder()
                   .url(path / "login")
                   .post(client.toString(), application(json))
                   .build()

        internal fun refreshToken(token: RefreshTokenRequest): Request =
            Request.Builder()
                   .url(path / "refreshTokens")
                   .post(token.toString(), application(json))
                   .build()

        internal fun updateIsMember(isMember: Boolean, email: String): Request =
            Request.Builder()
                   .url(path / "update" / "isMember" / email / isMember.toString())
                   .patch()
                   .build()
    }
}