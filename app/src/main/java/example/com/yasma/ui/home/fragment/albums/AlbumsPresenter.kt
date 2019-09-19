package example.com.yasma.ui.home.fragment.albums

import example.com.yasma.data.DataManager
import example.com.yasma.data.network.model.response.AlbumsResponse
import example.com.yasma.ui.base.BaseFragmentPresenter
import example.com.yasma.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
class AlbumsPresenter<V : AlbumsContract.View>
@Inject constructor(
    dataManager: DataManager,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BaseFragmentPresenter<V>(dataManager, schedulerProvider, compositeDisposable),
    AlbumsContract.Presenter<V> {

    private lateinit var mResponse: List<AlbumsResponse>

    override fun onAttach(view: V) {
        super.onAttach(view)

        getAlbumsData()
    }

    override fun getAlbumsData() {
        compositeDisposable.add(
            dataManager.getAlbumsData()
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

    override fun getAlbumsResponse(): List<AlbumsResponse> {
        return mResponse
    }

    override fun itemClicked(position: Int) {
        mResponse[position].id?.let { view?.launchPhotoActivity(it) }
    }
}