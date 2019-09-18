package example.com.yasma.ui.home.fragment.comments

import example.com.yasma.data.network.model.response.CommentsResponse
import example.com.yasma.ui.base.BaseFragmentContract

/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
interface CommentsContract {

    interface View: BaseFragmentContract.View{

        fun setUpRecyclerView()
    }

    interface Presenter<V: View>: BaseFragmentContract.Presenter<V>{

        fun setPostId(postId: Int)

        fun getCommentsData()

        fun getCommentsResponse(): List<CommentsResponse>
    }
}