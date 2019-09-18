package example.com.yasma.data.network.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
class CommentsResponse {

    @SerializedName("postId")
    @Expose
    val postId: Int? = null
    @SerializedName("id")
    @Expose
    val id: Int? = null
    @SerializedName("name")
    @Expose
    val name: String? = null
    @SerializedName("email")
    @Expose
    val email: String? = null
    @SerializedName("body")
    @Expose
    val body: String? = null


}