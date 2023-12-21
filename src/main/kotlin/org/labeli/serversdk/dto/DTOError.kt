package org.labeli.serversdk.dto

import org.labeli.serversdk.client.DisplayableError
import org.labeli.swift.RawRepresentable

internal interface DTOError: RawRepresentable<String>, DisplayableError {
    val beReported: Boolean
}

