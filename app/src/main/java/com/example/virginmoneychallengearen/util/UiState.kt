package com.example.virginmoneychallengearen.util

sealed class UiState<T>(
    val data: T? = null,
    val message: String? = null
){
    class Success<T>(data: T?): UiState<T>(data)
    class Error<T>(data: T?=null,message: String): UiState<T>(data,message)
    class Loading<T>: UiState<T>()
}
