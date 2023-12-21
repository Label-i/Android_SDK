package org.labeli.serversdk.dto.authentication.response

import org.labeli.serversdk.dto.Gettable

public class ClientPrivateResponse: Gettable {
    public val email: String
    public val fullname: String
    public val isMember: Boolean

    internal constructor(email: String, fullname: String, isMember: Boolean) {
        this.email = email
        this.fullname = fullname
        this.isMember = isMember
    }
}