package example.com.yasma.ui.photos

import example.com.yasma.data.DataManager
import example.com.yasma.data.network.model.response.PhotosResponse
import example.com.yasma.ui.base.BasePresenter
import example.com.yasma.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
class PhotosPresenter<V : PhotosContract.View>
@Inject constructor(
    dataManager: DataManager,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BasePresenter<V>(dataManager, schedulerProvider, compositeDisposable),
    PhotosContract.Presenter<V> {

    private lateinit var mResponse: List<PhotosResponse>

    private var albumId = 0

    override fun onAttach(view: V) {
        super.onAttach(view)

        view.initToolBar()
        getPhotosData()
    }

    override fun setALbumId(albumId: Int) {
        this.albumId = albumId
    }

    override fun getPhotosData() {
        compositeDisposable.add(
            dataManager.getPhotosData(albumId)
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

    override fun getPhotosResponse(): List<PhotosResponse> {
        return mResponse
    }
}