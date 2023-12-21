package org.labeli.serversdk.dto

import org.labeli.swift.CustomStringConvertible
import org.labeli.swift.Equatable
import org.labeli.swift.Hashable

internal interface Postable: Cloneable, Equatable, Hashable, CustomStringConvertible {
    public override fun clone(): Any
}