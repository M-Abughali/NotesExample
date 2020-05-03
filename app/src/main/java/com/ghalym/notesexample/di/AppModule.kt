package com.ghalym.notesexample.di

import android.app.Application
import com.ghalym.notesexample.MyApp
import dagger.Module
import dagger.Provides


@Module
class AppModule(val application: Application) {
    @Provides
    fun provideApplication():Application{
        return application;
    }
}