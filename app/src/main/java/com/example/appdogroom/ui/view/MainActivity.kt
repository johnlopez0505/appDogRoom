package com.example.appdogroom.ui.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appdogroom.databinding.ActivityMainBinding
import com.example.appdogroom.ui.adapter.DogAdapter
import com.example.appdogroom.ui.modelView.DogViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener{
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DogAdapter
    private val dogViewModel: DogViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mySearch.setOnQueryTextListener( this)
        initRecyclerView()
        adapter = DogAdapter()
        registerLiveData()
        loadDada()
        borrarBaseDatos()
    }

    private fun initRecyclerView(){
        binding.myRecyclerView.layoutManager =
            LinearLayoutManager( this)
    }

    private fun loadDada() {
        Toast.makeText(this,"Cargando la base de datos",
            Toast.LENGTH_LONG).show()

        dogViewModel.list()
    }


    @SuppressLint("NotifyDataSetChanged")
    private fun registerLiveData() {
        dogViewModel.dogListLiveData.observe(
            this
        ) { myList ->
            adapter.dogRepository = myList!!
            binding.myRecyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        }

        dogViewModel.progressBarLiveData.observe(
            this
        ) { visible ->
            binding.progressBar.isVisible = visible
        }

        dogViewModel.search.observe(this) {
            bread ->
            dogViewModel.listForBreed(bread)
            hideKeyBoard()
        }

        dogViewModel.text.observe(this){
            binding.textDog.text = it
        }

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query. isNullOrEmpty())
            dogViewModel.searchByBreed(query!!)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText. isNullOrEmpty()) {
            dogViewModel.list()
            hideKeyBoard()
        }
        return true
    }

    private fun hideKeyBoard() {
        val imn = getSystemService( INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow( binding.myRecyclerView .windowToken, 0)
    }

    private fun borrarBaseDatos(){
        binding.borrarBaseDatos.setOnClickListener{
            Toast.makeText(this,"Borrando la base de datos",
                Toast.LENGTH_LONG).show()
            dogViewModel.deleteBaseDatos()
        }
    }

}