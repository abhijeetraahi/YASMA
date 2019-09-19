package example.com.yasma.ui.home.fragment.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import example.com.yasma.R
import example.com.yasma.databinding.AlbumsFragmentBinding
import example.com.yasma.ui.base.BaseFragment
import example.com.yasma.ui.photos.PhotosActivity
import javax.inject.Inject

/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
class AlbumsFragment: BaseFragment(), AlbumsContract.View {

    private lateinit var mBinding: AlbumsFragmentBinding

    lateinit var mPresenter: AlbumsContract.Presenter<AlbumsContract.View>
        @Inject set

    lateinit var mAdapter: AlbumsAdapter
        @Inject set

    companion object {
        fun newInstance() = AlbumsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.albums_fragment, container, false)
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

    override fun launchPhotoActivity(albumsId: Int) {
        startActivity(this.context?.let { PhotosActivity.startActivity(it, albumsId) })
    }
}