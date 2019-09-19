package example.com.yasma.ui.home.fragment.users

import example.com.yasma.data.DataManager
import example.com.yasma.data.network.model.response.UsersResponse
import example.com.yasma.ui.base.BaseFragmentPresenter
import example.com.yasma.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Abhijeet Raahi on 19/09/2019.
 */
class UsersPresenter<V : UsersContract.View>
@Inject constructor(
    dataManager: DataManager,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BaseFragmentPresenter<V>(dataManager, schedulerProvider, compositeDisposable),
    UsersContract.Presenter<V> {

    private lateinit var mResponse: List<UsersResponse>

    override fun onAttach(view: V) {
        super.onAttach(view)

        getUsersData()
    }

    override fun getUsersData() {
        compositeDisposable.add(
            dataManager.getUsersData()
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

    override fun getUsersResponse(): List<UsersResponse> {
        return mResponse
    }
}