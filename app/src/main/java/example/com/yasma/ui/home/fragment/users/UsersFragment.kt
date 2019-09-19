package example.com.yasma.ui.home.fragment.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import example.com.yasma.R
import example.com.yasma.databinding.UsersFragmentBinding
import example.com.yasma.ui.base.BaseFragment
import javax.inject.Inject

/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
class UsersFragment: BaseFragment(), UsersContract.View {

    private lateinit var mBinding: UsersFragmentBinding

    lateinit var mPresenter: UsersContract.Presenter<UsersContract.View>
        @Inject set

    lateinit var mAdapter: UsersAdapter
        @Inject set

    companion object {
        fun newInstance() = UsersFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.users_fragment, container, false)
        getActivityComponent()?.inject(this)

        mPresenter.onAttach(this)
        return mBinding.root

    }

    override fun setUpRecyclerView() {

        with(mBinding.recyclerView){
            if (adapter == null)
                layoutManager = LinearLayoutManager(activity?.applicationContext)

            visibility = View.VISIBLE
            adapter = mAdapter

            hideProgressView()
        }
    }

    override fun hideProgressView() {
        mBinding.progressBar.visibility = View.GONE
    }

}