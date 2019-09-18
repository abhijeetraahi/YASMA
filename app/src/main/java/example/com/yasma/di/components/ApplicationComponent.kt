package example.com.yasma.di.components

import android.app.Application
import android.content.Context

import javax.inject.Singleton

import dagger.Component
import example.com.yasma.YasmaApplication
import example.com.yasma.data.DataManager
import example.com.yasma.di.ApplicationContext
import example.com.yasma.di.modules.ApplicationModule

/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: YasmaApplication)

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun dataManager(): DataManager
}
