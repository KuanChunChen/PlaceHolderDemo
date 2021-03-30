package c.money.interview_demo.ui.placeholder

import android.graphics.Bitmap
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import c.money.interview_demo.R
import c.money.interview_demo.base.BaseListAdapter
import c.money.interview_demo.model.api.GetPhotoResult

import android.graphics.drawable.BitmapDrawable
import android.util.Log
import c.money.interview_demo.base.http.HttpURLConnectionClient
import kotlinx.coroutines.*


abstract class PlaceHolderAdapter : BaseListAdapter<GetPhotoResult, PlaceHolderAdapter.ViewHolder>() {

    override val itemViewLayout: Int get() = R.layout.item_place

    override fun getItemViewHolder(itemView: View): ViewHolder {

        return ViewHolder(itemView)
    }

    inner class ViewHolder(var mItemView: View) : BaseViewHolder(mItemView) {

        private var textID: TextView = mItemView.findViewById(R.id.textId)
        private var textTitle: TextView = mItemView.findViewById(R.id.textTitle)
        private var container: ConstraintLayout = mItemView.findViewById(R.id.layout_container)

        override fun bind(position: Int) {
            val id = getItem(position).id.toString()
            val title = getItem(position).title.toString()
            val thumbnailUrl = getItem(position).thumbnailUrl.toString()
            textID.text = id
            textTitle.text = title

            val split: List<String>? = thumbnailUrl.split("/")
            val newUrl = "https://ipsumimage.appspot.com/" + split!![split.lastIndex - 1] + "," + split!![split.lastIndex]
            CoroutineScope(Dispatchers.IO).launch {
                val result = HttpURLConnectionClient().requestBitmap(newUrl)
                withContext(Dispatchers.Main) {

                    container.background = BitmapDrawable(mItemView.resources, result)

                }

            }
            mItemView.setOnClickListener {
                onItemClick(id, title, thumbnailUrl)
            }
        }


    }

    abstract fun onItemClick(id: String, title: String, thumbnailUrl: String)


}