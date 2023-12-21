package org.labeli.serversdk

internal interface Postable: Cloneable {
     public override fun clone(): Postable {
        return super.clone() as Postable
    }
}