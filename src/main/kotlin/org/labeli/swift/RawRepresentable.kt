package org.labeli.swift

public interface RawRepresentable<RawValue> {
    public val rawValue: RawValue
}

public inline fun <reified T, reified RawValue> init(rawValue: RawValue): T? where T: Enum<T>, T: RawRepresentable<RawValue> {
    for (entries in enumValues<T>())
        if (entries.rawValue == rawValue) return entries

    return null
}

public inline fun <reified T, reified RawValue> init(rawValue: RawValue): T? where T: Class<T>, T: RawRepresentable<RawValue> {
    TODO("Need to be implemented in your own class in a 'companion object' ;)")
}