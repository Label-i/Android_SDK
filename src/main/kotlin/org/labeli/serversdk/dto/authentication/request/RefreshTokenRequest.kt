package org.labeli.serversdk.dto.authentication.request

import org.labeli.serversdk.dto.Postable
import org.labeli.serversdk.extensions.clone
import java.util.*

internal class RefreshTokenRequest: Postable {
    private val refreshToken: String

    internal constructor(refreshToken: String) {
        this.refreshToken = refreshToken
    }

    override fun equals(other: Any?): Boolean =
        (other is RefreshTokenRequest) &&
                refreshToken == other.refreshToken

    override fun hashCode(): Int =
        Objects.hash(refreshToken)

    override fun toString(): String =
        "RefreshTokenRequest(refreshToken: $refreshToken)"

    override fun clone(): RefreshTokenRequest =
        RefreshTokenRequest(refreshToken.clone())
}
