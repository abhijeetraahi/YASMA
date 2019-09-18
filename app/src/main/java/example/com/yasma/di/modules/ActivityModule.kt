package example.com.yasma.di.modules


import androidx.appcompat.app.AppCompatActivity

import dagger.Module
import dagger.Provides
import example.com.yasma.data.DataManager
import example.com.yasma.data.YasmaDataManager
import example.com.yasma.data.network.ApiHelper
import example.com.yasma.data.network.YasmaApiHelper
import example.com.yasma.di.ActivityScope
import example.com.yasma.util.rx.SchedulerProvider
import example.com.yasma.util.rx.YasmaSchedulerProvider
import example.com.yasma.ui.home.HomeContract
import example.com.yasma.ui.home.HomePresenter
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
@Module
class ActivityModule(private val mActivity: AppCompatActivity) {

    @Provides
    @ActivityScope
    internal fun provideActivity(): AppCompatActivity {
        return mActivity
    }

    @Provides
    fun getSchedulerProvider(schedulerProvider: YasmaSchedulerProvider): SchedulerProvider {
        return schedulerProvider
    }

    @Provides
    fun getCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    fun getApiHelper(apiHelper: YasmaApiHelper): ApiHelper {
        return apiHelper
    }


    /*@Provides
    fun getDataManager(dataManager: YasmaDataManager): DataManager {
        return dataManager
    }*/

    @Provides
    @ActivityScope
    fun getHomeActivityPresenter(homePresenter: HomePresenter<HomeContract.View>): HomeContract.Presenter<HomeContract.View> {
        return homePresenter
    }
}
