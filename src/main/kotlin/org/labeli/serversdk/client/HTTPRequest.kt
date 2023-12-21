package org.labeli.serversdk.client

import org.labeli.serversdk.dto.Postable

/** An HTTP network request */
internal class HTTPRequest<Response> {
    /** HTTP Method, e.g. "GET" */
    private var method: HTTPMethod
    /** Resource String. Can be either absolute or relative. */
    private var url: String
    /** Request query items */
    private var query: ArrayList<Pair<String, String?>>? = null
    /** Request body */
    private var body: Postable? = null
    /** Request headers to be added to the request. */
    private var headers: HashMap<String, String>? = null

    /** Initializes the request with the given parameters */
    internal constructor(url: String, method: HTTPMethod = HTTPMethod.GET, query: ArrayList<Pair<String, String?>>? = null, body: Postable? = null, headers: HashMap<String, String>? = null) {
        this.method = method
        this.url = url.ifEmpty { "/" }
        this.query = query
        this.body = body
        this.headers = headers
    }

    private constructor(url: String, method: HTTPMethod) {
        this.url = url
        this.method = method
    }

    /** Changes the response type keeping the rest og the request parameters. */
    internal fun <T>withResponse(type: Class<T>): HTTPRequest<T> {
        val copy = HTTPRequest<T>(url.plus(""), method)
        copy.query = this.query?.toList()?.let { ArrayList(it) }
        copy.body = this.body?.clone() as Postable
        copy.headers = this.headers?.toMutableMap().let { HashMap(it) }
        return copy
    }
}