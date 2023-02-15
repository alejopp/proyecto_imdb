package com.example.alejobootcampandroid.data.service

<<<<<<< Updated upstream
=======
import android.util.Log
>>>>>>> Stashed changes
import com.example.alejobootcampandroid.R
import com.example.alejobootcampandroid.domain.service.ConfigService
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.get
import javax.inject.Inject
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
<<<<<<< Updated upstream
import kotlinx.coroutines.tasks.await

class ConfigServiceImpl @Inject constructor() : ConfigService {

    companion object{
        const val WITH_JETPACK_COMPOSE = "with_jetpack_compose"
        const val UPDATE_TIME = 3600L
    }

    private val remoteConfig = Firebase.remoteConfig
     private val configSettings = remoteConfigSettings {
=======
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class ConfigServiceImpl @Inject constructor() : ConfigService {

    private val remoteConfig = Firebase.remoteConfig
    private val configSettings = remoteConfigSettings {
>>>>>>> Stashed changes
        minimumFetchIntervalInSeconds = UPDATE_TIME
    }
    init {
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
    }

<<<<<<< Updated upstream
    override val withJetpackCompose: Boolean
        get() = remoteConfig.getBoolean(WITH_JETPACK_COMPOSE)

    override suspend fun fetchConfiguration()
       { remoteConfig.fetchAndActivate().await() }
=======
    override val defaultLanguage: String
        get() = remoteConfig[DEFAULT_LANGUAGE].asString()

    companion object {
        const val TAG = "config_service_impl"
        const val DEFAULT_LANGUAGE = "default_language"
        const val UPDATE_TIME = 3600L
    }

    override suspend fun fetchConfiguration()
    { remoteConfig.fetchAndActivate().await() }

   /* override suspend fun fetchConfiguration() {
        remoteConfig.fetchAndActivate().addOnCompleteListener { task ->
            if(task.isSuccessful){
                defaultLanguage = remoteConfig.getString(DEFAULT_LANGUAGE)
                Log.d(TAG, "Default language $defaultLanguage")
            } else{
                Log.e(TAG, "Could not fetch values from remote config")
            }
        }*/
>>>>>>> Stashed changes
}
