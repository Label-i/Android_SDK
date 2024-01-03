package org.labeli.serversdk

internal class HTTPRequest<out Response>(
    val url: String,
    val method: HTTPMethod = HTTPMethod.GET,
    val query: List<Pair<String, String?>>? = null,
    val body: Any? = null,
    val headers: Map<String, String>? = null
)