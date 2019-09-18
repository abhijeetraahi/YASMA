package example.com.yasma.ui.base

/**
 * Created by Abhijeet Raahi on 18/09/2019.
 */
interface BaseFragmentContract {

    interface View{
        fun showLoadingView()
        fun hideLoadingView()
    }

    interface Presenter<V: View>{
        fun onAttach(view: V)
        fun onDetach()
    }
}