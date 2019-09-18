package example.com.yasma.ui.home.fragment.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import example.com.yasma.R
import example.com.yasma.databinding.PostsFragmentBinding
import example.com.yasma.ui.base.BaseFragment
import example.com.yasma.ui.home.fragment.comments.CommentsFragment
import javax.inject.Inject

/**
 * Created by Abhijeet Raahi on 18/09/2019.
 */
class PostsFragment : BaseFragment(), PostsContract.View {

    private lateinit var mBinding: PostsFragmentBinding

    lateinit var mPresenter: PostsContract.Presenter<PostsContract.View>
        @Inject set

    lateinit var mAdapter: PostsAdapter
        @Inject set

    companion object {

        fun newInstance(): PostsFragment {
            val args = Bundle()
            val fragment = PostsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.posts_fragment, container, false)
        getActivityComponent()?.inject(this)

        mPresenter.onAttach(this)
        return mBinding.root

    }

    override fun setUpRecyclerView() {
        if (mBinding.recyclerView.adapter == null) {
            mBinding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        }

        mBinding.recyclerView.visibility = View.VISIBLE

        mBinding.recyclerView.adapter = mAdapter
    }


    override fun launchCommentsFragment(postId: Int) {

        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragment_container, CommentsFragment.newInstance(postId))
        transaction?.commit()
    }



}