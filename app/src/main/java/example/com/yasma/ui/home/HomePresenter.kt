package example.com.yasma.ui.home

import example.com.yasma.data.DataManager
import example.com.yasma.util.rx.SchedulerProvider
import example.com.yasma.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
class HomePresenter<V : HomeContract.View>
@Inject constructor(
    dataManager: DataManager,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BasePresenter<V>(dataManager, schedulerProvider, compositeDisposable),
    HomeContract.Presenter<V> {

    override fun onAttach(view: V) {
        super.onAttach(view)
        view.setNavigationItemSelectedListener()
    }
}