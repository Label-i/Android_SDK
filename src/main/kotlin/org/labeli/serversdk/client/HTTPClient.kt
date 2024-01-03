package org.labeli.serversdk.client

import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Response
import org.labeli.serversdk.dto.authentication.request.LoginRequest
import org.labeli.serversdk.endpoint.EndPoint
import java.io.IOException

public class Client {

    private val refreshToken: String
        get() = badRefreshToken
    private val accessToken: String
        get() = badAccessToken

    private val badRefreshToken = "bad_refresh_token"
    private val badAccessToken = "bad_access_token"

    private val client = OkHttpClient()

    public fun userLogin(email: String, password: String) {
        login(email, password, client=false)
    }

    public fun clientLogin(email: String, password: String) {
        login(email, password, client=true)
    }

    private fun login(email: String, password: String, client: Boolean) {
        val data = LoginRequest(email, password)
        val request = if (client) EndPoint.auth.client.login(data) else EndPoint.auth.user.login(data)
        this.client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }
            override fun onResponse(call: Call, response: Response) {
                TODO("Not yet implemented")
            }
        })
    }
}