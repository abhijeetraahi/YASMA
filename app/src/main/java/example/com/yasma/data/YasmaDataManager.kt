package example.com.yasma.data

import example.com.yasma.data.network.ApiHelper
import javax.inject.Inject


/**
 * Created by Abhijeet Raahi on 17/09/2019.
 */
class YasmaDataManager @Inject constructor(apiHelper: ApiHelper): DataManager{

    private var mApiHelper: ApiHelper = apiHelper

}
