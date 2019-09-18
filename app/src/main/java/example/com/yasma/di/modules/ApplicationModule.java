package example.com.yasma.di.modules;

import android.app.Application;
import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.com.yasma.BuildConfig;
import example.com.yasma.YasmaApplication;
import example.com.yasma.data.DataManager;
import example.com.yasma.data.YasmaDataManager;
import example.com.yasma.data.network.ApiHelper;
import example.com.yasma.data.network.YasmaApiHelper;
import example.com.yasma.di.ApplicationContext;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
@Module
public class ApplicationModule {

    private YasmaApplication application;

    public ApplicationModule(YasmaApplication application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context providesContext() {
        return application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    OkHttpClient getOKHttpClient() {

        return new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        return chain.proceed(
                                chain.request()
                                        .newBuilder()
                                        //.addHeader("Authorization", "Client-ID " + ImgurService.CLIENT_ID)
                                        .build());
                    }
                })
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    Retrofit getRetrofit(OkHttpClient defaultHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(defaultHttpClient)
                .build();
    }

    @Provides
    @Singleton
    ApiHelper getApiHelper(YasmaApiHelper apiHelper) {
        return apiHelper;
    }


    @Provides
    @Singleton
    DataManager getDataManager(YasmaDataManager dataManager) {
        return dataManager;
    }

}
