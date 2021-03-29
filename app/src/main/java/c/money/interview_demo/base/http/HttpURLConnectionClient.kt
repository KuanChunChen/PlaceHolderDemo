package c.money.interview_demo.base.http

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class HttpURLConnectionClient(hostName: String = HOST_JSON_PLACEHOLDER) {


    private var currentHostName: String? = hostName

    companion object {
        private const val HOST_JSON_PLACEHOLDER = "https://jsonplaceholder.typicode.com"
    }

    fun requestGET(endpoint: String): String? {
        val url = URL(currentHostName + endpoint)
        (url.openConnection() as? HttpURLConnection)?.run {
            requestMethod = "GET"
            val responseCode = responseCode
            println("Response Code :: $responseCode")
            return if (responseCode == HttpURLConnection.HTTP_OK) { // connection ok
                val bufferedReader = BufferedReader(InputStreamReader(inputStream))
                var inputLine: String?
                val response = StringBuffer()
                while (bufferedReader.readLine().also { inputLine = it } != null) {
                    response.append(inputLine)
                }
                bufferedReader.close()
                response.toString()
            } else {
                ""
            }
        }
        return ""

    }
}