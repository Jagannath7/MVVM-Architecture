package com.example.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.mvvm.data.models.User
import com.example.mvvm.data.repos.GithubRepository
import kotlinx.coroutines.*

class GithubViewModel : ViewModel() {

    val users = MutableLiveData<List<User>>()
    fun fetchUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = withContext(Dispatchers.IO){GithubRepository.getUsers()}
            if (response.isSuccessful){
                response.body()?.let {
                    users.postValue(it)
                }
            }
        }
    }

    fun searchusers(name:String) = liveData(Dispatchers.IO){
        val response = withContext(Dispatchers.IO){GithubRepository.searchUsers(name)}
        if(response.isSuccessful){
            response.body()?.let {
                emit(it.items)
            }
        }
    }
}

fun ViewModel.runIO(
    dispatchers: CoroutineDispatcher = Dispatchers.IO,
    function: suspend CoroutineScope.() -> Unit
) {
    viewModelScope.launch(dispatchers) {
        function()
    }
}

