package org.labeli.serversdk

internal class HTTPMediaType
    private constructor(private var type: String, private var subtype: String, private var parameters: HashMap<String, String> = HashMap())
{
    val rawValue: String
        get() = (listOf("$type/$subtype") + parameters.map { "${it.key}=${it.value}" }.sorted()).joinToString(";")

    companion object {
        val any = HTTPMediaType("*", "*")

        fun application(subtype: Application): HTTPMediaType =
            HTTPMediaType("application", subtype.rawValue)

        fun text(subtype: Text, charset: String? = null): HTTPMediaType {
            val input = HashMap<String, String>()
            if (!charset.isNullOrBlank())
                input["charset"] = charset
            return HTTPMediaType("text", subtype.rawValue, input)
        }

        fun multipart(subtype: MultiPart): HTTPMediaType =
            HTTPMediaType("multipart", subtype.rawValue)
    }

    class Application private constructor(internal val rawValue: String) {
        companion object {
            val json = Application("json")
            val schemaJson = Application("schema+json")
            val schemaInstanceJson = Application("schema-instance+json")
            val xml = Application("xml")
            val octetStream = Application("octet-stream")
            val urlEncoded = Application("x-www-form-urlencoded")
        }
    }

    class Text private constructor(internal val rawValue: String) {
        companion object {
            val plain = Text("plain")
            val html = Text("html")
        }
    }

    class MultiPart private constructor(internal val rawValue: String) {
        companion object {
            val formData = MultiPart("form-data")
            val byteranges = MultiPart("byteranges")
        }
    }
}