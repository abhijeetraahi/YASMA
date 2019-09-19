package example.com.yasma.ui.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomnavigation.BottomNavigationView
import example.com.yasma.databinding.HomeActivtyBinding
import example.com.yasma.ui.base.BaseActivity
import javax.inject.Inject
import android.view.MenuItem
import example.com.yasma.R
import example.com.yasma.ui.home.fragment.albums.AlbumsFragment
import io.reactivex.annotations.NonNull
import example.com.yasma.ui.home.fragment.posts.PostsFragment
import example.com.yasma.ui.home.fragment.users.UsersFragment
import example.com.yasma.util.replaceFragment
import example.com.yasma.util.updateActionBarTitle


/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
class HomeActivity : BaseActivity(), HomeContract.View {

    private lateinit var mBinding: HomeActivtyBinding

    lateinit var mPresenter: HomeContract.Presenter<HomeContract.View>
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.home_activty)

        activityComponent.inject(this)

        mPresenter.onAttach(this)

    }

    override fun setNavigationItemSelectedListener() {

        val mOnNavigationItemSelectedListener =
            object : BottomNavigationView.OnNavigationItemSelectedListener {

                override fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
                    when (item.itemId) {
                        R.id.navigation_posts -> {
                            replaceFragment(R.id.fragment_container, PostsFragment.newInstance(), "PostFragment")
                            updateActionBarTitle(R.string.title_posts, false)
                            return true
                        }

                        R.id.navigation_albums -> {
                            replaceFragment(R.id.fragment_container, AlbumsFragment.newInstance(), "AlbumsFragment")
                            updateActionBarTitle(R.string.title_albums, false)
                            return true
                        }

                        R.id.navigation_users -> {
                            replaceFragment(R.id.fragment_container, UsersFragment.newInstance(), "UsersFragment")
                            updateActionBarTitle(R.string.title_users, false)
                            return true
                        }
                    }
                    return false
                }
            }


        mBinding.navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        mBinding.navigationView.selectedItemId = R.id.navigation_posts
    }

}