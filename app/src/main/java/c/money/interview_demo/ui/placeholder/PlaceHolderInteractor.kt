package c.money.interview_demo.ui.placeholder

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PlaceHolderInteractor constructor(private val repo: PlaceHolderContract.Repo) : PlaceHolderContract.Interactor {


    override fun jsonPlaceHolderApi() {
        GlobalScope.launch(Dispatchers.IO) {
            repo.makeJsonPlaceHolderRequest()
        }
    }


}