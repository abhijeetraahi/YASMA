package example.com.yasma.ui.home.fragment.albums

import example.com.yasma.data.network.model.response.AlbumsResponse
import example.com.yasma.data.network.model.response.PostsResponse
import example.com.yasma.ui.base.BaseFragmentContract

/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
interface AlbumsContract {

    interface View: BaseFragmentContract.View{

        fun setUpRecyclerView()

        fun hideProgressView()

        fun launchPhotoActivity(albumsId: Int)
    }

    interface Presenter<V: View>: BaseFragmentContract.Presenter<V>{

        fun getAlbumsData()

        fun getAlbumsResponse(): List<AlbumsResponse>

        fun itemClicked(position: Int)
    }
}