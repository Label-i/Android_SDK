package org.labeli.serversdk.endpoint

import okhttp3.HttpUrl

internal class AuthResource(private val path: HttpUrl) {
    internal val user = UserResource(path.newBuilder()
                                         .addPathSegment("auth")
                                         .build())

    internal val client = ClientResource(path.newBuilder()
                                             .addPathSegment("client")
                                             .build())

    internal inner class UserResource(private val path: HttpUrl) {

    }

    internal  inner class ClientResource(private val path: HttpUrl) {

    }
}