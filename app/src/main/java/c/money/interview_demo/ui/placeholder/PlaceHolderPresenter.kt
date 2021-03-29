package c.money.interview_demo.ui.placeholder

class PlaceHolderPresenter constructor(
    private val router: PlaceHolderContract.Router,
    private val interactor: PlaceHolderContract.Interactor

) : PlaceHolderContract.Presenter {

    private var contractView : PlaceHolderContract.View? = null

    override fun bindView(view: PlaceHolderContract.View) {
        this.contractView = view
    }

    override fun unbindView() {
        this.contractView = null
    }

    override fun getDataFromServer() {

        interactor.jsonPlaceHolderApi()

    }


}