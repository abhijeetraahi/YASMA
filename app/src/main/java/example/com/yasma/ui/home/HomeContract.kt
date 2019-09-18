package example.com.yasma.ui.home

import example.com.yasma.ui.base.BaseContract

/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
interface HomeContract {

    interface View: BaseContract.View{
        fun setNavigationItemSelectedListener()
    }


    interface Presenter<V: View>: BaseContract.Presenter<V>
}