package org.labeli.serversdk.extensions

public operator fun String.div(other: String): String {
    return "$this/$other"
}

public fun String.clone(): String {
    return this.plus("")
}