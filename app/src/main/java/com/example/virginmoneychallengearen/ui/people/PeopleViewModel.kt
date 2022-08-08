package com.example.virginmoneychallengearen.ui.people

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.virginmoneychallengearen.model.people.PeopleModel
import com.example.virginmoneychallengearen.repository.Repository
import com.example.virginmoneychallengearen.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(var repository: Repository): ViewModel() {
    private val _details: MutableLiveData<UiState<PeopleModel>> = MutableLiveData(UiState.Loading())
    val details: LiveData<UiState<PeopleModel>> get() = _details

    fun getPeople(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getPeople()

            Log.i("res", response.body().toString())

            if (response.isSuccessful) {
                _details.postValue(
                    UiState.Success(response.body())
                )
            } else {
                _details.postValue(
                    UiState.Error(
                        null,
                        "People response unsuccessful"
                    )
                )
            }
        }
    }
}