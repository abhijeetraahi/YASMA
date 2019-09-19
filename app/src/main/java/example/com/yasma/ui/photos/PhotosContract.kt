package example.com.yasma.ui.photos

import example.com.yasma.data.network.model.response.PhotosResponse
import example.com.yasma.ui.base.BaseContract

/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
interface PhotosContract {

    interface View: BaseContract.View{

        fun initToolBar()

        fun setUpRecyclerView()

        fun hideProgressView()
    }

    interface Presenter<V: View>: BaseContract.Presenter<V>{

        fun setALbumId(albumId: Int)

        fun getPhotosData()

        fun getPhotosResponse(): List<PhotosResponse>
    }
}