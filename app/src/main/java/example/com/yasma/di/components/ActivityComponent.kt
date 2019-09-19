package example.com.yasma.di.components

import dagger.Component
import example.com.yasma.di.ActivityScope
import example.com.yasma.di.modules.ActivityModule
import example.com.yasma.ui.home.HomeActivity
import example.com.yasma.ui.comments.CommentsActivity
import example.com.yasma.ui.home.fragment.albums.AlbumsFragment
import example.com.yasma.ui.home.fragment.posts.PostsFragment
import example.com.yasma.ui.home.fragment.users.UsersFragment
import example.com.yasma.ui.photos.PhotosActivity

/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(homeActivity: HomeActivity)

    fun inject(postsFragment: PostsFragment)

    fun inject(commentsActivity: CommentsActivity)

    fun inject(albumsFragment: AlbumsFragment)

    fun inject(usersFragment: UsersFragment)

    fun inject(photosActivity: PhotosActivity)

}
