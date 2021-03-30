package c.money.interview_demo.ui.placeholder

import android.graphics.Bitmap
import c.money.interview_demo.model.api.GetPhotoResult
import c.money.interview_demo.model.api.Result

interface PlaceHolderContract {


    interface Repo{
        fun makeJsonPlaceHolderRequest():Result<List<GetPhotoResult>>
        fun makeImageRequest(url: String): Bitmap?

    }

    interface Interactor {
        suspend fun jsonPlaceHolderApi():Result<List<GetPhotoResult>>
        suspend fun makeImageRequestApi(url: String): Bitmap?
    }

    interface View {
        fun setRecyclerViewItem(data: List<GetPhotoResult>)
        fun setRecyclerViewItem()
        fun showErrorMessage(msg: String)
    }

    interface Presenter {
        fun bindView(view: View)
        fun unbindView()
        fun getDataFromServer()
        fun gotoDetailPage(id: String, title: String, url: String)

    }


    interface Router {
        fun startPlaceHolderDetailFragment(id: String, title: String, url: String)

    }


}