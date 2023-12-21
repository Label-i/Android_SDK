package org.labeli.serversdk.dto.authentication

import org.labeli.serversdk.client.DisplayableError
import org.labeli.swift.RawRepresentable

internal interface DTOError: DisplayableError, RawRepresentable<String> {
    val beReported: Boolean
}

