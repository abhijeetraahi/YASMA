package example.com.yasma.data.network

import example.com.yasma.data.network.model.response.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
interface ApiHelper {

    @GET("posts")
    fun getPostData(): Observable<List<PostsResponse>>

    @GET("posts/{postId}/comments")
    fun getCommentsData(@Path("postId") postId: Int): Observable<List<CommentsResponse>>

    @GET("albums")
    fun getAlbumsData(): Observable<List<AlbumsResponse>>

    @GET("users")
    fun getUsersData(): Observable<List<UsersResponse>>

    @GET("posts/{albumId}/photos")
    fun getPhotosData(@Path("albumId") albumId: Int): Observable<List<PhotosResponse>>

}