package com.example.virginmoneychallengearen.ui.rooms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.virginmoneychallengearen.model.rooms.RoomsModel
import com.example.virginmoneychallengearen.repository.Repository
import com.example.virginmoneychallengearen.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RoomsViewModel @Inject constructor(
    var repository: Repository
):ViewModel() {

    private val _rooms: MutableLiveData<UiState<RoomsModel>> = MutableLiveData(UiState.Loading())
    val rooms:LiveData<UiState<RoomsModel>> get() = _rooms

    fun getRooms() = CoroutineScope(Dispatchers.IO).launch {
        _rooms.postValue(UiState.Loading())
        val response = repository.getRooms()

        if (response.isSuccessful){
            _rooms.postValue(
                response.body()?.let {success->
                    UiState.Success(RoomsModel(success.resultCount,success.results))
                }
            )
        } else {
            _rooms.postValue(
                UiState.Error(null, "Rooms response unsuccessful")
            )
        }
    }

}
