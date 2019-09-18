package example.com.yasma.ui.base

import example.com.yasma.data.DataManager
import example.com.yasma.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Abhijeet Raahi on 18/09/2019.
 */
open class BaseFragmentPresenter<V : BaseFragmentContract.View> constructor(
    val dataManager: DataManager,
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable
) : BaseFragmentContract.Presenter<V> {

    var view: V? = null

    override fun onAttach(view: V) {
        this.view = view
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
    }
}