package com.example.appdogroom.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appdogroom.R
import com.example.appdogroom.domain.models.DogModel
import com.example.appdogroom.domain.models.Repository

class DogAdapter: RecyclerView.Adapter<ViewHDog>(){

    var dogRepository: List<DogModel> = Repository. dogs

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHDog {
        val layoutInflater = LayoutInflater.from(parent. context)
        val layoutItemRestaurant = R.layout.item_dogs
        return ViewHDog(
            layoutInflater.inflate(layoutItemRestaurant, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHDog, position: Int) {
        holder.render(dogRepository[position])
    }

    override fun getItemCount(): Int = dogRepository.size
}