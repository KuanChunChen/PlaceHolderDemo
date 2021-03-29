package c.money.interview_demo.ui.placeholder

import android.graphics.Bitmap
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

    override fun makeImageRequest(url: String): Bitmap? {

        return HttpURLConnectionClient().requestBitmap(url)
    }


    override fun makeJsonPlaceHolderRequest(): Result<List<GetPhotoResult>> {


        val responseData = HttpURLConnectionClient().requestGET(getPhotosEndpoint)

        if (responseData.isNullOrEmpty()) {
            return Result.Error(Exception("Cannot connect or get empty data"))

        }

        val listType: Type = object : TypeToken<List<GetPhotoResult?>?>() {}.type
        val fromJson: List<GetPhotoResult> = Gson().fromJson(responseData, listType)

        return Result.Success(fromJson)

    }


}