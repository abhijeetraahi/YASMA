package example.com.yasma.data.network.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
class UsersResponse {

    @SerializedName("id")
    @Expose
    val id: Int? = null
    @SerializedName("name")
    @Expose
    val name: String? = null
    @SerializedName("username")
    @Expose
    val username: String? = null
    @SerializedName("email")
    @Expose
    val email: String? = null
    @SerializedName("phone")
    @Expose
    val phone: String? = null
    @SerializedName("website")
    @Expose
    val website: String? = null

}
