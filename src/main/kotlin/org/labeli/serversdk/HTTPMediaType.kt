package org.labeli.serversdk

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType

internal class HTTPMediaType {
    private var type: String
    private var subtype: String
    private var parameters: HashMap<String, String>

    private val rawValue: String
        get() = (listOf("$type/$subtype") + parameters.map { "${it.key}=${it.value}" }.sorted()).joinToString(";")

    private constructor(type: String, subtype: String, parameters: HashMap<String, String> = HashMap()) {
        this.type = type
        this.subtype = subtype
        this.parameters = parameters
    }

    public val toMediaType: MediaType
        get() = rawValue.toMediaType()

    companion object {
        public val any = HTTPMediaType("*", "*")

        public fun application(subtype: Application): HTTPMediaType =
            HTTPMediaType("application", subtype.rawValue)

        public fun text(subtype: Text, charset: String? = null): HTTPMediaType {
            val input = HashMap<String, String>()
            if (!charset.isNullOrBlank())
                input["charset"] = charset
            return HTTPMediaType("text", subtype.rawValue, input)
        }

        public fun multipart(subtype: MultiPart): HTTPMediaType =
            HTTPMediaType("multipart", subtype.rawValue)
    }

    public class Application {
        internal val rawValue: String

        private constructor(rawValue: String) {
            this.rawValue = rawValue
        }

        companion object {
            public val json = Application("json")
            public val schemaJson = Application("schema+json")
            public val schemaInstanceJson = Application("schema-instance+json")
            public val xml = Application("xml")
            public val octetStream = Application("octet-stream")
            public val urlEncoded = Application("x-www-form-urlencoded")
        }
    }

    public class Text {
        internal val rawValue: String

        private constructor(rawValue: String) {
            this.rawValue = rawValue
        }

        companion object {
            public val plain = Text("plain")
            public val html = Text("html")
        }
    }

    public class MultiPart {
        internal val rawValue: String

        private constructor(rawValue: String) {
            this.rawValue = rawValue
        }

        public val formData = MultiPart("form-data")
        public val byteranges = MultiPart("byteranges")
    }
}