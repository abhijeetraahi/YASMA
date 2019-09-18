package example.com.yasma.util.rx

import io.reactivex.Scheduler

/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
interface SchedulerProvider {

    fun ui(): Scheduler
    fun io(): Scheduler
}