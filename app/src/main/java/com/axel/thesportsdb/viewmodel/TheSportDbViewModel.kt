package com.axel.thesportsdb.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axel.thesportsdb.model.league.LeaguesResponse
import com.axel.thesportsdb.repository.TheSportDbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TheSportDbViewModel
@Inject constructor(private val theSportDbRepository: TheSportDbRepository): ViewModel()
{
    private val _responseLeague = MutableLiveData<LeaguesResponse>()
    val responseLeague : LiveData<LeaguesResponse>
        get() = _responseLeague

    init {
        getLeague()
    }

    private fun getLeague() = viewModelScope.launch {
        theSportDbRepository.getLeague().let {response ->
            if (response.isSuccessful) {
                _responseLeague.postValue(response.body())
            }else{
                Log.d("Response Error", "${response.code()}")
            }
        }
    }

}