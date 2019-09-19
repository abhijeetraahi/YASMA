package example.com.yasma.ui.base

import android.content.Context

/**
 * Created by Abhijeet Raahi on 18/09/2019.
 */
interface BaseFragmentContract {

    interface View{
        fun showToast(context: Context, message: String)
        fun showToast(context: Context, message: String, length: Int)
    }

    interface Presenter<V: View>{
        fun onAttach(view: V)
        fun onDetach()
    }
}