package org.labeli.serversdk.dto.authentication.response

import kotlinx.serialization.Serializable
import org.labeli.serversdk.dto.Gettable

@Serializable
class TokenResponse: Gettable {
    val accessToken: String
    val refreshToken: String

    internal constructor(accessToken: String, refreshToken: String) {
        this.accessToken = accessToken
        this.refreshToken = refreshToken
    }
}
