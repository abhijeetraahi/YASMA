package example.com.yasma.ui.base

import android.app.ProgressDialog
import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import example.com.yasma.R
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        activityComponent = DaggerActivityComponent.builder().activityModule(ActivityModule(this))
            .applicationComponent((application as YasmaApplication).appComponent)
            .build()

    }

    override fun showLoading() {

        if (!::mProgressDialog.isInitialized)
            mProgressDialog = showLoadingDialog(this)

        hideLoading()

        if (mProgressDialog.isShowing)
            return

        if (!this.isFinishing) {
            mProgressDialog = showLoadingDialog(this)
        }
    }

    override fun hideLoading() {

        if (!::mProgressDialog.isInitialized)
            return

        if (this.isFinishing)
            return

        if (mProgressDialog.isShowing) {
            mProgressDialog.dismiss()
        }
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


    private fun showLoadingDialog(context: Context): ProgressDialog {

        val progressDialog = ProgressDialog(context)
        progressDialog.show()
        if (progressDialog.window != null) {
            progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        progressDialog.setContentView(R.layout.yasma_progress_bar)
        progressDialog.isIndeterminate = true
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)
        return progressDialog
    }
}