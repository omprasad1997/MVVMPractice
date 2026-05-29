package com.example.mvvmpractice.mvvm_xml_live_data.di

import com.example.mvvmpractice.mvvm_xml_live_data.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}