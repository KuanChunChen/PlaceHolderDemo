package c.money.interview_demo.base.util

import android.content.Context
import android.net.ConnectivityManager


object NetworkUtil {


    /***TODO 舊版方法 已經 Deprecated
     * android 7以上有新方法***/
    fun isConnect(context: Context): Boolean {

        var haveConnectedWifi = false
        var haveConnectedMobile = false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val netInfo = connectivityManager!!.allNetworkInfo
        for (ni in netInfo) {
            if (ni.typeName
                    .equals("WIFI", ignoreCase = true)
            ) if (ni.isConnected) haveConnectedWifi = true
            if (ni.typeName
                    .equals("MOBILE", ignoreCase = true)
            ) if (ni.isConnected) haveConnectedMobile = true
        }
        return haveConnectedWifi || haveConnectedMobile

    }


}