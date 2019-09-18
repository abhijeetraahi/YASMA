package example.com.yasma

import android.app.Application
import example.com.yasma.di.components.ApplicationComponent
import example.com.yasma.di.components.DaggerApplicationComponent
import example.com.yasma.di.modules.ApplicationModule

/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
class YasmaApplication: Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        appComponent =
            DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
    }
}