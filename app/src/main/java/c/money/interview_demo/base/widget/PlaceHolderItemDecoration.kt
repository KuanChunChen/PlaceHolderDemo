package c.money.interview_demo.base.widget

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class PlaceHolderItemDecoration(private val context: Context) :  RecyclerView.ItemDecoration() {



    var mItemConsumeX = context.resources.displayMetrics.widthPixels / 4
    var mItemConsumeY = context.resources.displayMetrics.heightPixels / 6




    /**
     *
     * Adjust the recycler distance between each item.
     *
     * @param outRect Rect to receive the output.
     * @param view    The child view to decorate
     * @param parent  RecyclerView this ItemDecoration is decorating
     * @param state   The current state of RecyclerView.
     */
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        val layoutParams = view.layoutParams as RecyclerView.LayoutParams

        if (layoutParams.width != mItemConsumeX) {
            layoutParams.width = mItemConsumeX
        }


        if (layoutParams.height != mItemConsumeY) {
            layoutParams.height = mItemConsumeY
        }


    }




}