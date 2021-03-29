package c.money.interview_demo.ui.mainpage

class MainPagePresenter constructor(private val router: MainPageRouter) : MainPageContract.Presenter {
    private var contractView : MainPageContract.View? = null


    override fun bindView(view: MainPageContract.View) {
        this.contractView = view
    }

    override fun unbindView() {
        this.contractView = null
    }

    override fun getPlaceHolder() {

        router.startPlaceHolderFragment()
    }


}
