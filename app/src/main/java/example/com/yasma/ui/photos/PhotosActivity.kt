package example.com.yasma.ui.photos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import example.com.yasma.R
import example.com.yasma.databinding.PhotosActivityBinding
import example.com.yasma.ui.base.BaseActivity
import example.com.yasma.util.updateActionBarTitle
import javax.inject.Inject

/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
class PhotosActivity: BaseActivity(), PhotosContract.View {

    private lateinit var mBinding: PhotosActivityBinding

    lateinit var mPresenter: PhotosContract.Presenter<PhotosContract.View>
        @Inject set

    lateinit var mAdapter: PhotosAdapter
        @Inject set

    companion object {

        private const val ALBUM_ID = "ALBUM_ID"

        fun startActivity(context: Context, albumId: Int): Intent {

            val intent = Intent(context, PhotosActivity::class.java)
            intent.putExtra(ALBUM_ID, albumId)
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.photos_activity)

        activityComponent.inject(this)

        mPresenter.setALbumId(intent.getIntExtra(ALBUM_ID, 0))

        mPresenter.onAttach(this)

    }

    override fun initToolBar() {
        updateActionBarTitle(R.string.title_photos, true)
    }

    override fun setUpRecyclerView() {
        with(mBinding.recyclerView){
            if (adapter == null)
                layoutManager = GridLayoutManager(this@PhotosActivity, 2)

            visibility = View.VISIBLE
            adapter = mAdapter

            hideProgressView()
        }
    }

    override fun hideProgressView() {
        mBinding.progressBar.visibility = View.GONE
    }
}