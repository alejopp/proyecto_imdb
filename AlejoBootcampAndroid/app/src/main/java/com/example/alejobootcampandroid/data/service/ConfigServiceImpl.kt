package com.example.alejobootcampandroid.data.service


import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.domain.service.ConfigService
import com.google.firebase.ktx.Firebase
import javax.inject.Inject
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import kotlinx.coroutines.tasks.await

class ConfigServiceImpl @Inject constructor() : ConfigService {

    companion object{
        const val WITH_JETPACK_COMPOSE = "with_jetpack_compose"
        const val UPDATE_TIME = 3600L
    }

    private val remoteConfig = Firebase.remoteConfig
     private val configSettings = remoteConfigSettings {
        minimumFetchIntervalInSeconds = UPDATE_TIME
    }
    init {
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
    }

    override val withJetpackCompose: Boolean
        get() = remoteConfig.getBoolean(WITH_JETPACK_COMPOSE)

    override suspend fun fetchConfiguration()
       { remoteConfig.fetchAndActivate().await() }

}
