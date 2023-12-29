package org.labeli.serversdk.extensions

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.labeli.serversdk.HTTPMediaType

internal inline fun <reified T>Request.Builder.post(content: T, mediaType: HTTPMediaType): Request.Builder =
    post(Json.encodeToString(content).toRequestBody(mediaType.toMediaType))

internal fun Request.Builder.patch(): Request.Builder =
    patch("".toRequestBody())
