package example.com.yasma.ui.home.fragment.comments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import example.com.yasma.R
import example.com.yasma.databinding.CommentsFragmentBinding
import example.com.yasma.ui.base.BaseFragment
import javax.inject.Inject

/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
class CommentsFragment : BaseFragment(), CommentsContract.View {

    private lateinit var mBinding: CommentsFragmentBinding

    lateinit var mPresenter: CommentsContract.Presenter<CommentsContract.View>
        @Inject set

    lateinit var mAdapter: CommentsAdapter
        @Inject set


    companion object {

        private const val POST_ID = "POST_ID"

        fun newInstance(postId: Int): CommentsFragment {
            val args = Bundle()
            args.putInt(POST_ID, postId)
            val fragment = CommentsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.comments_fragment, container, false)
        getActivityComponent()?.inject(this)

        arguments?.getInt(POST_ID)?.let { mPresenter.setPostId(it) }
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
}