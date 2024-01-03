package org.labeli.serversdk.extensions

import okhttp3.HttpUrl

internal fun HttpUrl.Builder.addQueryParameters(list: List<Pair<String, String?>>): HttpUrl.Builder {
    list.forEach { this.addQueryParameter(it.first, it.second) }
    return this
}