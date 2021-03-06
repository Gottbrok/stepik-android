package org.stepic.droid.di.network

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import org.stepic.droid.di.AppSingleton
import org.stepic.droid.util.StethoHelper

@Module
abstract class NetworkUtilModule {

    @Module
    companion object {
        @AppSingleton
        @Provides
        @JvmStatic
        @StethoInterceptor
        fun provideStethoInterceptor(): Interceptor =
                StethoHelper.getInterceptor()
    }
}