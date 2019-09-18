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
import example.com.yasma.ui.home.fragment.comments.CommentsAdapter
import example.com.yasma.ui.home.fragment.comments.CommentsContract
import example.com.yasma.ui.home.fragment.comments.CommentsPresenter
import example.com.yasma.ui.home.fragment.posts.PostsAdapter
import example.com.yasma.ui.home.fragment.posts.PostsContract
import example.com.yasma.ui.home.fragment.posts.PostsPresenter
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
@Module
class ActivityModule(private val mActivity: AppCompatActivity) {

    @Provides
    @ActivityScope
    fun provideActivity(): AppCompatActivity {
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

    @Provides
    @ActivityScope
    fun getHomeActivityPresenter(homePresenter: HomePresenter<HomeContract.View>): HomeContract.Presenter<HomeContract.View> {
        return homePresenter
    }

    @Provides
    @ActivityScope
    fun getPostsPresenter(postsPresenter: PostsPresenter<PostsContract.View>): PostsContract.Presenter<PostsContract.View> {
        return postsPresenter
    }


    @Provides
    @ActivityScope
    fun getPostsAdapter(presenter: PostsContract.Presenter<PostsContract.View>): PostsAdapter {
        return PostsAdapter(presenter)
    }

    @Provides
    @ActivityScope
    fun getCommentsPresenter(commentsContract: CommentsPresenter<CommentsContract.View>): CommentsContract.Presenter<CommentsContract.View> {
        return commentsContract
    }


    @Provides
    @ActivityScope
    fun getCommentsAdapter(presenter: CommentsContract.Presenter<CommentsContract.View>): CommentsAdapter {
        return CommentsAdapter(presenter)
    }
}
