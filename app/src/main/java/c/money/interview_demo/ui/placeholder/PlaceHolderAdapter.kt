package c.money.interview_demo.ui.placeholder

import android.view.View
import android.widget.TextView
import c.money.interview_demo.R
import c.money.interview_demo.base.BaseListAdapter
import c.money.interview_demo.model.ui.PlaceHolderModel

abstract class PlaceHolderAdapter : BaseListAdapter<PlaceHolderModel, PlaceHolderAdapter.ViewHolder>() {

    override val itemViewLayout: Int get() = R.layout.item_place

    override fun getItemViewHolder(itemView: View): ViewHolder {

        return ViewHolder(itemView)
    }

    inner class ViewHolder(var mItemView: View) : BaseViewHolder(mItemView) {

        private var textID: TextView = mItemView.findViewById(R.id.textId)
        private var textTitle: TextView = mItemView.findViewById(R.id.textTitle)

        override fun bind(position: Int) {
            textID.text = getItem(position).data?.id.toString()
            textTitle.text = getItem(position).data?.title.toString()
        }
    }
}