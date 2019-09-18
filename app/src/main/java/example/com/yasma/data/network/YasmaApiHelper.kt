package example.com.yasma.data.network

import retrofit2.Retrofit
import javax.inject.Inject


/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
class YasmaApiHelper @Inject constructor(retrofit: Retrofit): ApiHelper {

    private var mApiHelper: ApiHelper = retrofit.create<ApiHelper>(ApiHelper::class.java)

    /*private lateinit var retrofit: Retrofit

    fun getRetrofit(): Retrofit {

        if (!::retrofit.isInitialized) {
            val builder = OkHttpClient.Builder()
            val okHttpClient = builder.build()

            retrofit = Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
        }

        return retrofit
    }*/

}