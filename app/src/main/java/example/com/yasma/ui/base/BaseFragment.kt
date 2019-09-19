package example.com.yasma.ui.base

import android.content.Context
import android.widget.Toast
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

    override fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun showToast(context: Context, message: String, length: Int) {
        Toast.makeText(context, message, length).show()
    }

}