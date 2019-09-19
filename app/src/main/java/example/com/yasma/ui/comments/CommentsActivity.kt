package example.com.yasma.ui.comments

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import example.com.yasma.databinding.CommentsActivityBinding
import example.com.yasma.ui.base.BaseActivity
import javax.inject.Inject
import android.content.Context
import android.content.Intent
import example.com.yasma.R
import example.com.yasma.util.updateActionBarTitle


/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
class CommentsActivity : BaseActivity(), CommentsContract.View {

    private lateinit var mBinding: CommentsActivityBinding

    lateinit var mPresenter: CommentsContract.Presenter<CommentsContract.View>
        @Inject set

    lateinit var mAdapter: CommentsAdapter
        @Inject set


    companion object {

        private const val POST_ID = "POST_ID"

        fun startActivity(context: Context, postId: Int): Intent {

            val intent = Intent(context, CommentsActivity::class.java)
            intent.putExtra(POST_ID, postId)
            return intent
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.comments_activity)

        activityComponent.inject(this)

        mPresenter.setPostId(intent.getIntExtra(POST_ID, 0))

        mPresenter.onAttach(this)

    }

    override fun initToolBar() {
        updateActionBarTitle(R.string.title_comments, true)
    }

    override fun setUpRecyclerView() {
        with(mBinding.recyclerView){
            if (adapter == null)
                layoutManager = LinearLayoutManager(this@CommentsActivity)

            visibility = View.VISIBLE
            adapter = mAdapter

            hideProgressView()
        }
    }

    override fun hideProgressView() {
        mBinding.progressBar.visibility = View.GONE
    }

}