package org.labeli.serversdk.extensions

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.labeli.serversdk.HTTPMediaType

internal fun Request.Builder.addHeaders(headers: Map<String, String>?): Request.Builder {
    headers?.forEach { addHeader(it.key, it.value) }
    return this
}

internal fun Request.Builder.delete(body: String?, mediaType: HTTPMediaType): Request.Builder =
    delete(body?.toRequestBody(mediaType.rawValue.toMediaType()))

internal fun Request.Builder.patch(body: String, mediaType: HTTPMediaType): Request.Builder =
    patch(body.toRequestBody(mediaType.rawValue.toMediaType()))

internal fun Request.Builder.post(body: String, mediaType: HTTPMediaType): Request.Builder =
    post(body.toRequestBody(mediaType.rawValue.toMediaType()))

internal fun Request.Builder.put(): Request.Builder =
    put("".toRequestBody())

internal fun Request.Builder.put(body: String, mediaType: HTTPMediaType): Request.Builder =
    put(body.toRequestBody(mediaType.rawValue.toMediaType()))
