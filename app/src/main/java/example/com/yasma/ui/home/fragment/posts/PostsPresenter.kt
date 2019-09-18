package example.com.yasma.ui.home.fragment.posts

import example.com.yasma.data.DataManager
import example.com.yasma.data.network.model.response.PostsResponse
import example.com.yasma.ui.base.BaseFragmentPresenter
import example.com.yasma.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Abhijeet Raahi on 18/09/2019.
 */
class PostsPresenter<V : PostsContract.View>
@Inject constructor(
    dataManager: DataManager,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BaseFragmentPresenter<V>(dataManager, schedulerProvider, compositeDisposable),
    PostsContract.Presenter<V> {

    private lateinit var mResponse: List<PostsResponse>

    override fun onAttach(view: V) {
        super.onAttach(view)
        getPostsData()
    }

    override fun getPostsData() {

        compositeDisposable.add(
            dataManager.getPostData()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({ response ->
                    mResponse = response
                    if (mResponse.isNotEmpty())
                        view?.setUpRecyclerView()

                }, {
                })

        )
    }

    override fun getPostsResponse(): List<PostsResponse> {
        return mResponse
    }

    override fun showComment(position: Int) {
        mResponse[position].id?.let { view?.launchCommentsFragment(it) }
    }

}