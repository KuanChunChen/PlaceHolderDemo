package c.money.interview_demo.base.http

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.util.Log


class HttpURLConnectionClient(hostName: String = HOST_JSON_PLACEHOLDER) {


    private var currentHostName: String? = hostName

    companion object {
        private const val HOST_JSON_PLACEHOLDER = "https://jsonplaceholder.typicode.com"


    }


    @Throws(IOException::class)
    fun requestGET(hostName: String, endpoint: String): String? {
        val url = URL(hostName + endpoint)
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

    @Throws(IOException::class)
    fun requestGET(endpoint: String): String? {
        return requestGET(currentHostName!!,endpoint)
    }


    fun requestBitmap(imageUrl: String): Bitmap? {
        Log.d("asfdafd","$imageUrl")
        return try {
            val url = URL(imageUrl)
            (url.openConnection() as? HttpURLConnection)?.run {
                requestMethod = "GET"
                doInput = true
                setRequestProperty("User-Agent","User-Agent: Mozilla/5.0 (Windows NT 6.1; rv:7.0.1) Gecko/20100101 Firefox/7.0.1")
                connect()
                val responseCode = responseCode
                if (responseCode == HttpURLConnection.HTTP_OK) {
                   return BitmapFactory.decodeStream(inputStream)

                }
                return null
            }


        } catch (e: IOException) {
            e.printStackTrace()
            null
        }

    }



}