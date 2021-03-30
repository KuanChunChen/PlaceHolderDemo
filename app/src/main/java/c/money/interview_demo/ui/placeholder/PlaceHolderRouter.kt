package c.money.interview_demo.ui.placeholder

import android.os.Bundle
import c.money.interview_demo.R
import c.money.interview_demo.ui.placeholderdetail.PlaceHolderDetailFragment

class PlaceHolderRouter(private val fragment: PlaceHolderFragment) : PlaceHolderContract.Router {


    override fun startPlaceHolderDetailFragment(id: String, title: String, url: String) {

        val bundle = Bundle()
        bundle.putString(BundleKey.EXTRA_KEY_ID.name, id)
        bundle.putString(BundleKey.EXTRA_KEY_TITLE.name, title)
        bundle.putString(BundleKey.EXTRA_KEY_URL.name, url)

        val targetFragment = PlaceHolderDetailFragment.newInstance()
        targetFragment.arguments = bundle

        fragment.requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, targetFragment, targetFragment.javaClass.name)
            .addToBackStack(null)
            .commit()

    }



}


enum class BundleKey{EXTRA_KEY_ID,EXTRA_KEY_TITLE,EXTRA_KEY_URL}