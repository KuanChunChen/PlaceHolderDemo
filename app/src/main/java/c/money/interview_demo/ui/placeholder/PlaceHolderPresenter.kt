package c.money.interview_demo.ui.placeholder

import android.graphics.Bitmap
import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import c.money.interview_demo.model.api.Result

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

    override fun getImageFromUrl(url: String) {
        val job = CoroutineScope(Dispatchers.IO).launch {

            val result = interactor.makeImageRequestApi(url)

            withContext(Dispatchers.Main) {

                contractView?.setRecyclerViewItem()

            }


        }


    }

    override fun getDataFromServer() {

        CoroutineScope(Dispatchers.IO).launch {

            val result = interactor.jsonPlaceHolderApi()

            withContext(Dispatchers.Main) {
                when(result){
                    is Result.Success->{
                        Log.d("satdt", "${Gson().toJson(result.data)}")
                        contractView?.setRecyclerViewItem(result.data)

                    }
                    is Result.Error->{
                        Log.d("satdt", "${Gson().toJson(result.exception)}")
                    }
                }
            }


        }




    }


}