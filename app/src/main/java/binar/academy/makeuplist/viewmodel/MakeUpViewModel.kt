package binar.academy.makeuplist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import binar.academy.makeuplist.model.ResponseMakeUpItem
import binar.academy.makeuplist.network.MakeUpEndPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MakeUpViewModel @Inject constructor(private val api : MakeUpEndPoint) : ViewModel() {
    private var liveDataMakeUp: MutableLiveData<List<ResponseMakeUpItem>> = MutableLiveData()

    fun getLiveDataMakeUp() : MutableLiveData<List<ResponseMakeUpItem>> = liveDataMakeUp

    fun showAllDataMakeUp(){
        api.getAllMakeUp()
            .enqueue(object : Callback<List<ResponseMakeUpItem>>{
                override fun onResponse(
                    call: Call<List<ResponseMakeUpItem>>,
                    response: Response<List<ResponseMakeUpItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataMakeUp.postValue(response.body())
                    }else{
                        liveDataMakeUp.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseMakeUpItem>>, t: Throwable) {
                    liveDataMakeUp.postValue(null)
                }

            })
    }
}