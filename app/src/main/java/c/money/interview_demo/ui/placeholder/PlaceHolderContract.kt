package c.money.interview_demo.ui.placeholder

import c.money.interview_demo.model.api.GetPhotoResult
import c.money.interview_demo.model.ui.PlaceHolderModel
import c.money.interview_demo.model.api.Result

interface PlaceHolderContract {


    interface Repo{
        fun makeJsonPlaceHolderRequest():Result<GetPhotoResult>


    }

    interface Interactor {
        fun jsonPlaceHolderApi()

    }

    interface View {
        fun setRecyclerViewItem(data: PlaceHolderModel)

    }

    interface Presenter {
        fun bindView(view: View)
        fun unbindView()
        fun getDataFromServer()

    }


    interface Router {
        fun startPlaceHolderDetailFragment()

    }


}