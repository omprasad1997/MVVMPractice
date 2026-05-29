package com.example.mvvmpractice.mvvm_clean_xml_live_data.di

import com.example.mvvmpractice.mvvm_clean_xml_live_data.presentation.ui.MainActivity2
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, RepositoryModule::class, UseCaseModule::class])
interface AppComponent2 {
    fun inject(mainActivity2: MainActivity2)
}