package example.com.yasma.ui.home.fragment.comments

import example.com.yasma.data.DataManager
import example.com.yasma.data.network.model.response.CommentsResponse
import example.com.yasma.ui.base.BaseFragmentPresenter
import example.com.yasma.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
class CommentsPresenter<V : CommentsContract.View>
@Inject constructor(
    dataManager: DataManager,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BaseFragmentPresenter<V>(dataManager, schedulerProvider, compositeDisposable),
    CommentsContract.Presenter<V> {

    private var postId = 0
    private lateinit var mResponse: List<CommentsResponse>

    override fun onAttach(view: V) {
        super.onAttach(view)
        getCommentsData()
    }

    override fun setPostId(postId: Int) {
        this.postId = postId
    }


    override fun getCommentsData() {
        compositeDisposable.add(
            dataManager.getCommentsData(postId)
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

    override fun getCommentsResponse(): List<CommentsResponse> {
        return mResponse
    }
}