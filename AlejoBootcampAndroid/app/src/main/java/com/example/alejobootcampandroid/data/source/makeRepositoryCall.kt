package com.example.alejobootcampandroid.data.source

import com.example.alejobootcampandroid.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

suspend fun <T> makeRepositoryCall(
    call: suspend () -> T
): ResponseStatus<T> = withContext(Dispatchers.IO) {
    try {
        ResponseStatus.Success(call())
    } catch (e: UnknownHostException) {
        ResponseStatus.Error(R.string.unknown_host_exception)
    } catch (e: Exception) {
        val errorMessage = R.string.network_error
        ResponseStatus.Error(errorMessage)
    } // TODO("Add all catches")
}