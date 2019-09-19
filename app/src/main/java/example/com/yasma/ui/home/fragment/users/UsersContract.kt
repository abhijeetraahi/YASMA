package example.com.yasma.ui.home.fragment.users

import example.com.yasma.data.network.model.response.UsersResponse
import example.com.yasma.ui.base.BaseFragmentContract

/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
interface UsersContract {

    interface View: BaseFragmentContract.View{

        fun setUpRecyclerView()

        fun hideProgressView()

    }

    interface Presenter<V: View>: BaseFragmentContract.Presenter<V>{

        fun getUsersData()

        fun getUsersResponse(): List<UsersResponse>

    }
}