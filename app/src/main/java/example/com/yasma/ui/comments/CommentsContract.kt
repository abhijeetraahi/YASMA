package example.com.yasma.ui.comments

import example.com.yasma.data.network.model.response.CommentsResponse
import example.com.yasma.ui.base.BaseContract
import example.com.yasma.ui.base.BaseFragmentContract

/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
interface CommentsContract {

    interface View: BaseContract.View{

        fun initToolBar()

        fun setUpRecyclerView()

        fun hideProgressView()
    }

    interface Presenter<V: View>: BaseContract.Presenter<V>{

        fun setPostId(postId: Int)

        fun getCommentsData()

        fun getCommentsResponse(): List<CommentsResponse>
    }
}