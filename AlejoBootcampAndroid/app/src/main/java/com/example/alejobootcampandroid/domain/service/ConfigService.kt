package com.example.alejobootcampandroid.domain.service

interface ConfigService {
    val withJetpackCompose: Boolean
    suspend fun fetchConfiguration()
}
