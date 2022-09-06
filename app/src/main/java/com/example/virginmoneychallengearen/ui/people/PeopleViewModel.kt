package com.example.virginmoneychallengearen.ui.people

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.virginmoneychallengearen.model.people.PeopleModel
import com.example.virginmoneychallengearen.repository.Repository
import com.example.virginmoneychallengearen.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(var repository: Repository): ViewModel() {
//    private val _details: MutableLiveData<UiState<PeopleModel>> = MutableLiveData(UiState.Loading())
    private val _details: MutableStateFlow<UiState<PeopleModel>> = MutableStateFlow(UiState.Loading())
    val details: StateFlow<UiState<PeopleModel>> get() = _details

    fun getPeople(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getPeople()

//            Log.i("res", response.body().toString())

            if (response.isSuccessful) {
                _details.value = (
                    UiState.Success(response.body())
                )
            } else {
                _details.value = (
                    UiState.Error(
                        null,
                        "People response unsuccessful"
                    )
                )
            }
        }
    }
}