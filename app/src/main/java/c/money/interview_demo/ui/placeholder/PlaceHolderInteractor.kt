package c.money.interview_demo.ui.placeholder

import android.graphics.Bitmap
import c.money.interview_demo.model.api.GetPhotoResult
import c.money.interview_demo.model.api.Result

class PlaceHolderInteractor constructor(private val repo: PlaceHolderContract.Repo) : PlaceHolderContract.Interactor {

    override suspend fun makeImageRequestApi(url: String): Bitmap? = repo.makeImageRequest(url)

    override suspend fun jsonPlaceHolderApi(): Result<List<GetPhotoResult>> = repo.makeJsonPlaceHolderRequest()


}