package example.com.yasma.di.modules


import androidx.appcompat.app.AppCompatActivity

import dagger.Module
import dagger.Provides
import example.com.yasma.data.network.ApiHelper
import example.com.yasma.data.network.YasmaApiHelper
import example.com.yasma.di.ActivityScope
import example.com.yasma.util.rx.SchedulerProvider
import example.com.yasma.util.rx.YasmaSchedulerProvider
import example.com.yasma.ui.home.HomeContract
import example.com.yasma.ui.home.HomePresenter
import example.com.yasma.ui.comments.CommentsAdapter
import example.com.yasma.ui.comments.CommentsContract
import example.com.yasma.ui.comments.CommentsPresenter
import example.com.yasma.ui.home.fragment.albums.AlbumsAdapter
import example.com.yasma.ui.home.fragment.albums.AlbumsContract
import example.com.yasma.ui.home.fragment.albums.AlbumsPresenter
import example.com.yasma.ui.home.fragment.posts.PostsAdapter
import example.com.yasma.ui.home.fragment.posts.PostsContract
import example.com.yasma.ui.home.fragment.posts.PostsPresenter
import example.com.yasma.ui.home.fragment.users.UsersAdapter
import example.com.yasma.ui.home.fragment.users.UsersContract
import example.com.yasma.ui.home.fragment.users.UsersPresenter
import example.com.yasma.ui.photos.PhotosAdapter
import example.com.yasma.ui.photos.PhotosContract
import example.com.yasma.ui.photos.PhotosPresenter
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

    @Provides
    @ActivityScope
    fun getAlbumsPresenter(albumsPresenter: AlbumsPresenter<AlbumsContract.View>): AlbumsContract.Presenter<AlbumsContract.View> {
        return albumsPresenter
    }


    @Provides
    @ActivityScope
    fun getAlbumsAdapter(presenter: AlbumsContract.Presenter<AlbumsContract.View>): AlbumsAdapter {
        return AlbumsAdapter(presenter)
    }

    @Provides
    @ActivityScope
    fun getUsersPresenter(usersPresenter: UsersPresenter<UsersContract.View>): UsersContract.Presenter<UsersContract.View> {
        return usersPresenter
    }


    @Provides
    @ActivityScope
    fun getUsersAdapter(presenter: UsersContract.Presenter<UsersContract.View>): UsersAdapter {
        return UsersAdapter(presenter)
    }

    @Provides
    @ActivityScope
    fun getPhotosPresenter(photosPresenter: PhotosPresenter<PhotosContract.View>): PhotosContract.Presenter<PhotosContract.View> {
        return photosPresenter
    }


    @Provides
    @ActivityScope
    fun getPhotosAdapter(presenter: PhotosContract.Presenter<PhotosContract.View>): PhotosAdapter {
        return PhotosAdapter(presenter)
    }

}
