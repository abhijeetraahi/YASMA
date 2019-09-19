package example.com.yasma.data.network.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
class PhotosResponse {

    @SerializedName("albumId")
    @Expose
    val albumId: Int? = null
    @SerializedName("id")
    @Expose
    val id: Int? = null
    @SerializedName("title")
    @Expose
    val title: String? = null
    @SerializedName("url")
    @Expose
    val url: String? = null
    @SerializedName("thumbnailUrl")
    @Expose
    val thumbnailUrl: String? = null
}