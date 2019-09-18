package example.com.yasma.ui.base

import android.content.Context
import androidx.fragment.app.Fragment
import example.com.yasma.di.components.ActivityComponent

/**
 * Created by Abhijeet Raahi on 18/09/2019.
 */
abstract class BaseFragment: Fragment(), BaseFragmentContract.View {

    private lateinit var mActivity: BaseActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            this.mActivity = context
        }
    }

    fun getActivityComponent(): ActivityComponent? {
        return if (::mActivity.isInitialized) {
            mActivity.activityComponent
        } else null
    }


    override fun showLoadingView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoadingView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}