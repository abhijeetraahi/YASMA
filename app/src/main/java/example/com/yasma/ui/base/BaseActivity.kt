package example.com.yasma.ui.base

import android.app.ProgressDialog
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import example.com.yasma.YasmaApplication
import example.com.yasma.di.components.ActivityComponent
import example.com.yasma.di.components.DaggerActivityComponent
import example.com.yasma.di.modules.ActivityModule

/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
abstract class BaseActivity: AppCompatActivity(), BaseContract.View {

    lateinit var activityComponent: ActivityComponent
    private lateinit var mProgressDialog: ProgressDialog

    var screenWidth: Int = 0
    var screenHeight: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        screenHeight = displayMetrics.heightPixels
        screenWidth = displayMetrics.widthPixels

        activityComponent = DaggerActivityComponent.builder().activityModule(ActivityModule(this))
            .applicationComponent((application as YasmaApplication).appComponent)
            .build()

    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}