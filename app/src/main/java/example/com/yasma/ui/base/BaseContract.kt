package example.com.yasma.ui.base

/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
class BaseContract {

    interface View{
        fun showToast(message: String)
        fun showToast(message: String, length: Int)
    }

    interface Presenter<V: View>{
        fun onAttach(view: V)
        fun onDetach()
    }
}