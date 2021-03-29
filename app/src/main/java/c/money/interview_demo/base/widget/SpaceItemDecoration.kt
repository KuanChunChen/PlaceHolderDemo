package c.money.interview_demo.base.widget

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpaceItemDecoration(val context: Context, private var mSpace: Int) :  RecyclerView.ItemDecoration() {


    var mItemConsumeX = context.resources.displayMetrics.widthPixels / 4




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

        val itemCount = parent.adapter?.itemCount ?: 0
        val position = parent.getChildAdapterPosition(view)
        val metric = context.resources.displayMetrics

        val layoutParams = view.layoutParams as RecyclerView.LayoutParams

        val width = metric.widthPixels
        val height = metric.heightPixels
        val density = metric.density
        val densityDpi = metric.densityDpi


        if (layoutParams.width != mItemConsumeX) {
            layoutParams.width = mItemConsumeX
        }




    }




}