package example.com.yasma.di.components

import dagger.Component
import example.com.yasma.di.ActivityScope
import example.com.yasma.di.modules.ActivityModule
import example.com.yasma.ui.home.HomeActivity

/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(homeActivity: HomeActivity)

}
