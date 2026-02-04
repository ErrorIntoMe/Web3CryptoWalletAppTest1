package com.example.appcompose.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _isFollowing: MutableLiveData<Boolean> = MutableLiveData()
    val isFollowing: LiveData<Boolean> = _isFollowing


    fun changeFollow(){
        val follow = _isFollowing.value ?: false
        _isFollowing.value = !follow
    }
}