package example.com.yasma.data.network

import example.com.yasma.data.network.model.response.CommentsResponse
import example.com.yasma.data.network.model.response.PostsResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject


/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
class YasmaApiHelper @Inject constructor(retrofit: Retrofit): ApiHelper {

    private var mApiHelper: ApiHelper = retrofit.create<ApiHelper>(ApiHelper::class.java)

    override fun getPostData(): Observable<List<PostsResponse>> {
        return mApiHelper.getPostData()
    }

    override fun getCommentsData(postId: Int): Observable<List<CommentsResponse>> {
        return mApiHelper.getCommentsData(postId)
    }

}