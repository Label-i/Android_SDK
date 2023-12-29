package org.labeli.serversdk.extensions

import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.labeli.serversdk.HTTPMediaType

internal fun Request.Builder.post(content: String, mediaType: HTTPMediaType): Request.Builder =
    post(content.toRequestBody(mediaType.toMediaType))

internal fun Request.Builder.patch(): Request.Builder =
    patch("".toRequestBody())
