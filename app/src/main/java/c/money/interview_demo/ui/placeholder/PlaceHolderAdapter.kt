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
            textID.text = getItem(position).id.toString()
            textTitle.text = getItem(position).title.toString()

            val thumbnailUrl = getItem(position).thumbnailUrl.toString()
            reLoadImageUrl(thumbnailUrl)
//            Log.d("sdfa","$bitmap")
//            container.background = BitmapDrawable(mItemView.resources, bitmap)


        }


    }

    abstract fun reLoadImageUrl(thumbnailUrl: String)
    fun setTEst(){

    }
}