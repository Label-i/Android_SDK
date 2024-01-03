package org.labeli.serversdk

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Request
import org.labeli.serversdk.HTTPMediaType.Application.Companion.json
import org.labeli.serversdk.HTTPMediaType.Companion.application
import org.labeli.serversdk.extensions.*
import org.labeli.serversdk.extensions.addHeaders
import org.labeli.serversdk.extensions.delete
import org.labeli.serversdk.extensions.patch
import org.labeli.serversdk.extensions.post

internal class HTTPRequest<out Response>(
    private val url: String,
    private val method: HTTPMethod = HTTPMethod.GET,
    private val query: List<Pair<String, String?>>? = null,
    private val body: Any? = null,
    private val headers: Map<String, String>? = null)
{

    @Throws internal fun makeURLRequest(baseURL: String, encoder: Json): Request =
        makeURLRequest(baseURL, encoder) { }

    @Throws internal fun makeURLRequest(baseURL: String, encoder: Json, configure: ((Request.Builder) -> Unit)? = null): Request {
        val requestBuilder = Request.Builder()
        requestBuilder.url(makeURL(baseURL))
        requestBuilder.addHeaders(headers)

        var body: String? = null
        if (this.body != null) {
            body = encoder.encodeToString(this.body)
            requestBuilder.header("Content-Type", application(json).rawValue)
        }

        when (method) {
            HTTPMethod.DELETE -> requestBuilder.delete(body, application(json))
            HTTPMethod.GET -> requestBuilder.get()
            HTTPMethod.HEAD -> requestBuilder.head()
            HTTPMethod.OPTIONS -> TODO("Not implemented in okhttp3")
            HTTPMethod.PATCH -> requestBuilder.patch(body!!, application(json))
            HTTPMethod.POST -> requestBuilder.post(body!!, application(json))
            HTTPMethod.PUT -> if (body != null) requestBuilder.put(body, application(json)) else requestBuilder.put()
            HTTPMethod.TRACE -> TODO("Not implementd in okhttp3")
        }

        requestBuilder.header("Accept", application(json).rawValue)

        if (configure != null) { configure(requestBuilder) }

        return requestBuilder.build()
    }

    @Throws private fun makeURL(baseURL: String): HttpUrl {
        val fullURL = (baseURL / this.url).toHttpUrl()

        if (!this.query.isNullOrEmpty()) {
            return fullURL.newBuilder().addQueryParameters(this.query).build()
        }

        return fullURL
    }
}

