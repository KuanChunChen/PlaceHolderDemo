package c.money.interview_demo.ui.placeholder

import c.money.interview_demo.model.api.Result
import kotlinx.coroutines.*

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

    override fun gotoDetailPage(id: String, title: String, url: String) {
        router.startPlaceHolderDetailFragment(id, title, url)
    }

    override fun getDataFromServer() {

        GlobalScope.launch(Dispatchers.IO) {

            val result = interactor.jsonPlaceHolderApi()

            withContext(Dispatchers.Main) {
                when(result){
                    is Result.Success->{

                        contractView?.setRecyclerViewItem(result.data)

                    }
                    is Result.Error->{
                        contractView?.showErrorMessage(result.exception.message.toString())
                    }
                }
            }


        }




    }


}