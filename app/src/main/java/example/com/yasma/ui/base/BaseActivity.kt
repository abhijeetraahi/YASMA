package example.com.yasma.ui.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MenuItem
import android.widget.Toast
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        activityComponent = DaggerActivityComponent.builder().activityModule(ActivityModule(this))
            .applicationComponent((application as YasmaApplication).appComponent)
            .build()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showToast(message: String, length: Int) {
        Toast.makeText(this, message, length).show()
    }
}