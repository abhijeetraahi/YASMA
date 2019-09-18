package example.com.yasma.ui.base

import example.com.yasma.data.DataManager
import example.com.yasma.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
open class BasePresenter<V : BaseContract.View> constructor(
    val dataManager: DataManager,
    val schedulerProvider: SchedulerProvider,
    private val compositeDisposable: CompositeDisposable
) : BaseContract.Presenter<V> {

    private var view: V? = null

    override fun onAttach(view: V) {
        this.view = view
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
    }
}