package example.com.yasma.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import example.com.yasma.R
import example.com.yasma.databinding.HomeActivtyBinding
import example.com.yasma.ui.base.BaseActivity
import javax.inject.Inject

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

    override fun showToast() {
        Toast.makeText(this, "Yeah setup is done!!!", Toast.LENGTH_LONG).show()
    }

}