package org.labeli.serversdk.dto.authentication.response

import org.labeli.serversdk.dto.Gettable

public class TokenResponse: Gettable {
    public val accessToken: String
    public val refreshToken: String

    internal constructor(accessToken: String, refreshToken: String) {
        this.accessToken = accessToken
        this.refreshToken = refreshToken
    }
}
