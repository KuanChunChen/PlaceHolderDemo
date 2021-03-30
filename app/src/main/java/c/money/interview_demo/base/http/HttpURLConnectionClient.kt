package c.money.interview_demo.base.http

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import c.money.interview_demo.model.api.GetPhotoResult
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


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
        return try {
            val url = URL(imageUrl)
            (url.openConnection() as? HttpURLConnection)?.run {
                requestMethod = "GET"
                doInput = true

                setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_8; en-US) AppleWebKit/532.5 (KHTML, like Gecko) Chrome/4.0.249.0 Safari/532.5");

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

    fun parseResponseByOrigin(responseData: String):List<GetPhotoResult?> {

        val jsonObject = JSONObject(responseData)
        val list = mutableListOf<GetPhotoResult?>()

        val jsonArray: JSONArray = JSONArray(responseData)
        for (i in 0 until jsonArray.length()) {
            val jsonRow = jsonArray.getJSONObject(i)

            list.add(
                GetPhotoResult(
                    jsonRow.getInt("albumId"),
                    jsonRow.getInt("id"),
                    jsonRow.getString("title"),
                    jsonRow.getString("url"),
                    jsonRow.getString("thumbnailUrl")
                )
            )
        }

        return list as List<GetPhotoResult>

    }



}