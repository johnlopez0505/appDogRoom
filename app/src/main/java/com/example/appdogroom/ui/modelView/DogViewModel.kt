package com.example.appdogroom.ui.modelView



import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appdogroom.domain.models.DogModel
import com.example.appdogroom.domain.useCase.DeleteBaseDataUseCase
import com.example.appdogroom.domain.useCase.GetDogsBreedUseCase
import com.example.appdogroom.domain.useCase.GetDogsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class DogViewModel @Inject constructor(
    private val useCaseList : GetDogsUseCase,
    private val getDogsBreedUseCaseProvider: Provider<GetDogsBreedUseCase>,
    private val deleteBaseDatosCaseUse : DeleteBaseDataUseCase
)  : ViewModel() {
    var dogListLiveData = MutableLiveData<List<DogModel>>()
    var progressBarLiveData = MutableLiveData<Boolean> ()
    var search = MutableLiveData<String>()
    val text = MutableLiveData<String>()

    fun searchByBreed(breed: String){
        search.value = breed
    }
    fun list() {
        viewModelScope.launch {
            progressBarLiveData.value = true
            delay(2000)
            val data: List<DogModel>? = useCaseList()
            data.let {
                dogListLiveData.value = it
                text.value = ""
                progressBarLiveData.value = false
            }
        }
    }
    fun listForBreed(breed: String) {
        viewModelScope.launch {
            progressBarLiveData.value = true
            val useCaseBreedList = getDogsBreedUseCaseProvider.get()
            useCaseBreedList.setBreed(breed)
            val data : List<DogModel> ? = useCaseBreedList()
            data.let {
                dogListLiveData.value = it
                if(data!!.isEmpty())
                    text.value = "No se ha encontrado el perro en la lista"
                progressBarLiveData.value = false
            }
        }
    }

    fun deleteBaseDatos(){
        viewModelScope.launch {
            deleteBaseDatosCaseUse()
            list()
        }
    }
}