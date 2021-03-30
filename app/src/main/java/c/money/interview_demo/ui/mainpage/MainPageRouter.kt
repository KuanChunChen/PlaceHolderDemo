package c.money.interview_demo.ui.mainpage

import c.money.interview_demo.R
import c.money.interview_demo.ui.placeholder.PlaceHolderFragment

class MainPageRouter(private val activity: MainActivity) : MainPageContract.Router {

    override fun startPlaceHolderFragment() {

        val targetFragment = PlaceHolderFragment.newInstance()
        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, targetFragment, targetFragment.javaClass.name)
            .addToBackStack(null)
            .commit()


    }


}