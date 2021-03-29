package c.money.interview_demo.ui.placeholder

import android.view.View
import c.money.interview_demo.R
import c.money.interview_demo.base.BaseListAdapter
import c.money.interview_demo.model.ui.PlaceHolderModel

abstract class PlaceHolderAdapter : BaseListAdapter<PlaceHolderModel, PlaceHolderAdapter.ViewHolder>() {

    override val itemViewLayout: Int get() = R.layout.item_place

    override fun getItemViewHolder(itemView: View): ViewHolder {

        return ViewHolder(itemView)
    }

    inner class ViewHolder(var mItemView: View) : BaseViewHolder(mItemView) {

        override fun bind(position: Int) {

        }
    }
}