package com.example.alejobootcampandroid.data.service

/*
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.domain.service.ConfigService
import com.google.firebase.ktx.Firebase
import javax.inject.Inject
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

class ConfigServiceImpl @Inject constructor() : ConfigService {

    companion object{
        const val DEFAULT_LANGUAGE = "default_language"
        const val UPDATE_TIME = 3600L
    }

    private val remoteConfig = Firebase.remoteConfig
     val configSettings = remoteConfigSettings {
        minimumFetchIntervalInSeconds = UPDATE_TIME
    }
    init {
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
    }

    override val defaultLanguage: String
        get() = remoteConfig.getString(DEFAULT_LANGUAGE)

    override suspend fun fetchConfiguration()
       { remoteConfig.fetchAndActivate() }
}*/
