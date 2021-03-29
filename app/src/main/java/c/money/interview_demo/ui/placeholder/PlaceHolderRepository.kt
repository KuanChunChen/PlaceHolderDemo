package c.money.interview_demo.ui.placeholder

import c.money.interview_demo.base.http.HttpURLConnectionClient
import c.money.interview_demo.model.api.GetPhotoResult
import c.money.interview_demo.model.api.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class PlaceHolderRepository : PlaceHolderContract.Repo {

    companion object {
        private const val getPhotosEndpoint = "/photos"
    }




    override fun makeJsonPlaceHolderRequest(): Result<GetPhotoResult> {


        val sttt = HttpURLConnectionClient().requestGET(getPhotosEndpoint)
        println("requestGET sttt :: $sttt")
        val listType: Type = object : TypeToken<List<GetPhotoResult?>?>() {}.type

        val fromJson: List<*> = Gson().fromJson(sttt, listType)
        println("fromJson Code :: ${Gson().toJson(fromJson)}")

//
//        (url.openConnection() as? HttpURLConnection)?.run {
//            requestMethod = "GET"
////            setRequestProperty("Content-Type", "application/json")
////            setRequestProperty("User-Agent", "Chrome/{Chrome Rev} Mobile Safari/{WebKit Rev}")
//
//
//
//            doOutput = true
//            doInput = true
//            connectTimeout = 10000
////            outputStream.write(jsonBody.toByteArray())
//            connect()
//            inputStream.bufferedReader().use { reader ->
//                val data = reader.readText()
//                print("data :$data")
//                Log.d("test", data)
//            }
////            val responseCode: Int = responseCode
////            var response: String? = ""
////            print("responseCode:$responseCode")
////
////            if (responseCode == HttpsURLConnection.HTTP_OK) {
////                var line: String
////                val br =
////                    BufferedReader(InputStreamReader(inputStream))
////                while (br.readLine().also { line = it } != null) {
////                    response += line
////                }
////            } else {
////                response = ""
////            }
//
////            val reader: Reader = InputStreamReader(inputStream, "UTF-8")
////            val listType: Type = object : TypeToken<List<GetPhotoResult?>?>() {}.type
////
////            val fromJson: List<*> = Gson().fromJson(reader, listType)
//
////            print(response)
////            val result: JsonResult = Gson().fromJson<JsonResult>(reader, JsonResult::class.java)
////
////            var test = Gson().fromJson(reader, Result<GetPhotoResult>::class.java)

//            return Result.Error(Exception("Cannot open HttpURLConnection"))
//            return Result.Success(responseParser.parse(inputStream))
//        }
        return Result.Error(Exception("Cannot open HttpURLConnection"))

    }


}