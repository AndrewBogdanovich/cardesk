package com.example.cardesk

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import com.example.cardesk.di.appModule
import com.example.cardesk.di.dataModule
import com.example.cardesk.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application(), ImageLoaderFactory {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }

    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this).diskCache {
            DiskCache.Builder()
                .directory(this@App.cacheDir.resolve("image_cache"))
                .maxSizePercent(0.02)
                .build()

        }
            .respectCacheHeaders(false)
            .build()
    }
}