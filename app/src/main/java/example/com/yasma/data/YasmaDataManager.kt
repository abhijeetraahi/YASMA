package example.com.yasma.data

import example.com.yasma.data.network.ApiHelper
import example.com.yasma.data.network.model.response.*
import io.reactivex.Observable
import javax.inject.Inject


/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
class YasmaDataManager @Inject constructor(apiHelper: ApiHelper): DataManager{

    private var mApiHelper: ApiHelper = apiHelper

    override fun getPostData(): Observable<List<PostsResponse>> {
        return mApiHelper.getPostData()
    }

    override fun getCommentsData(postId: Int): Observable<List<CommentsResponse>> {
        return mApiHelper.getCommentsData(postId)
    }

    override fun getAlbumsData(): Observable<List<AlbumsResponse>> {
        return mApiHelper.getAlbumsData()
    }

    override fun getUsersData(): Observable<List<UsersResponse>> {
        return mApiHelper.getUsersData()
    }

    override fun getPhotosData(albumId: Int): Observable<List<PhotosResponse>> {
        return mApiHelper.getPhotosData(albumId)
    }

}
