package c.money.interview_demo

import c.money.interview_demo.model.api.GetPhotoResult

interface PlaceHolderContract {


    interface Repo{
        fun getJsonPlaceHolder()


    }

    interface Interactor {
        fun getJsonPlaceHolderApi()

    }

    interface View {
        fun setRecyclerViewItem(data: List<GetPhotoResult>)

    }

    interface Presenter {

    }


    interface Router {
        fun startPlaceHolderFragment()
        fun startPlaceHolderDetailFragment()

    }


}