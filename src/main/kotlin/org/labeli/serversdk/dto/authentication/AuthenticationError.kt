package org.labeli.serversdk.dto.authentication

import org.labeli.serversdk.dto.DTOError
import org.labeli.swift.RawRepresentable

// TODO: Add localized description
internal enum class AuthenticationError(override val rawValue: String): DTOError, RawRepresentable<String> {
    EMPTY_EMAIL("emptyEmail"),
    EMPTY_REFRESH_TOKEN("emptyRefreshToken"),
    FULLNAME_TO_SHORT("fullnameToShort"),
    MALFORMED_EMAIL("malformedEmail"),
    MALFORMED_FULLNAME("malformedFullname"),
    PASSWORD_TO_LONG("passwordToLong"),
    PASSWORD_TO_SHORT("passwordToShort"),
    CLIENT_NOT_FOUND("clientNotFound"),
    CAN_SELL_PARAMETER_MISSING("anSellParameterMissing"),
    EMAIL_ALREADY_EXISTS("emailAlreadyExists"),
    EMAIL_PARAMETER_MISSING("emailParameterMissing"),
    IS_ADMIN_PARAMETER_MISSING("isAdminParameterMissing"),
    INVALID_PASSWORD("invalidPassword"),
    IS_MEMBER_PARAMETER_MISSING("isMemberParameterMissing"),
    PASSWORD_NOT_EQUAL("passwordNotEqual"),
    REFRESH_TOKEN_EXPIRED("refreshTokenExpired"),
    REFRESH_TOKEN_NOT_FOUND("refreshTokenNotFound"),
    USER_NOT_FOUND("userNotFound");

    override val title: String get() = when (this) {
        EMPTY_EMAIL,
        EMPTY_REFRESH_TOKEN,
        FULLNAME_TO_SHORT,
        MALFORMED_EMAIL,
        MALFORMED_FULLNAME,
        PASSWORD_TO_LONG,
        PASSWORD_TO_SHORT,
        PASSWORD_NOT_EQUAL -> "Validation Error"
        CLIENT_NOT_FOUND,
        CAN_SELL_PARAMETER_MISSING,
        EMAIL_ALREADY_EXISTS,
        EMAIL_PARAMETER_MISSING,
        IS_ADMIN_PARAMETER_MISSING,
        INVALID_PASSWORD,
        IS_MEMBER_PARAMETER_MISSING,
        REFRESH_TOKEN_EXPIRED,
        REFRESH_TOKEN_NOT_FOUND,
        USER_NOT_FOUND -> "Server Error"
    }

    override val message: String by ::rawValue

    override val beReported: Boolean get() = when (this) {
        EMPTY_EMAIL,
        USER_NOT_FOUND,
        MALFORMED_EMAIL,
        CLIENT_NOT_FOUND,
        PASSWORD_TO_LONG,
        INVALID_PASSWORD,
        PASSWORD_TO_SHORT,
        FULLNAME_TO_SHORT,
        PASSWORD_NOT_EQUAL,
        MALFORMED_FULLNAME,
        EMAIL_ALREADY_EXISTS -> true
        EMPTY_REFRESH_TOKEN,
        REFRESH_TOKEN_EXPIRED,
        REFRESH_TOKEN_NOT_FOUND,
        EMAIL_PARAMETER_MISSING,
        CAN_SELL_PARAMETER_MISSING,
        IS_ADMIN_PARAMETER_MISSING,
        IS_MEMBER_PARAMETER_MISSING -> false
    }
}
