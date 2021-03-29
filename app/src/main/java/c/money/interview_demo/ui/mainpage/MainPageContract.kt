package c.money.interview_demo.ui.mainpage




interface MainPageContract {

    interface View {

    }

    interface Presenter {
        fun bindView(view: View)
        fun unbindView()
        fun getPlaceHolder()
    }


    interface Router {
        fun startPlaceHolderFragment()
    }


}