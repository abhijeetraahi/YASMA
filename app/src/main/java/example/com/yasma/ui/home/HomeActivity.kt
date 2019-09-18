package example.com.yasma.ui.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomnavigation.BottomNavigationView
import example.com.yasma.databinding.HomeActivtyBinding
import example.com.yasma.ui.base.BaseActivity
import javax.inject.Inject
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import example.com.yasma.R
import io.reactivex.annotations.NonNull
import example.com.yasma.ui.home.fragment.posts.PostsFragment


/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
class HomeActivity : BaseActivity(), HomeContract.View {

    private lateinit var mBinding: HomeActivtyBinding

    lateinit var mPresenter: HomeContract.Presenter<HomeContract.View>
        @Inject set

    /*private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_posts -> {
                replaceFragment(R.id.fragment, PostsFragment.newInstance(), "PostsFragment")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_albums -> {
                replaceFragment(R.id.fragment, PostsFragment.newInstance(), "AlbumsFragment")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_user_details -> {
                replaceFragment(R.id.fragment, PostsFragment.newInstance(), "UsersDetailsFragment")
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, example.com.yasma.R.layout.home_activty)

        activityComponent.inject(this)

        mPresenter.onAttach(this)

    }

    override fun setNavigationItemSelectedListener() {

        val mOnNavigationItemSelectedListener =
            object : BottomNavigationView.OnNavigationItemSelectedListener {

                override fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
                    val fragment: Fragment
                    when (item.itemId) {
                        R.id.navigation_posts -> {
                            fragment = PostsFragment.newInstance()
                            loadFragment(fragment)
                            return true
                        }

                        R.id.navigation_albums -> {
                            fragment = PostsFragment.newInstance()
                            loadFragment(fragment)
                            return true
                        }

                        R.id.navigation_users -> {
                            fragment = PostsFragment.newInstance()
                            loadFragment(fragment)
                            return true
                        }
                    }
                    return false
                }
            }


        mBinding.navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        mBinding.navigationView.selectedItemId = R.id.navigation_posts
    }

    private fun loadFragment(fragment: Fragment) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    fun AppCompatActivity.updateActionBarTitle(actionBarTitle: Int, isEnabled: Boolean) {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(isEnabled)
            title = getString(actionBarTitle)
        }
    }
}