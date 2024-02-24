package com.example.appdogroom.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appdogroom.databinding.ItemDogsBinding
import com.example.appdogroom.domain.models.DogModel


class ViewHDog (view: View): RecyclerView.ViewHolder (view) {

    private var binding: ItemDogsBinding
    init {
        binding = ItemDogsBinding.bind(view)
    }

    fun render(dog : DogModel){
        binding.txtviewName.text = dog.breed

        Glide
            .with( itemView.context)
            .load(dog.image)
            .centerCrop()
            .into( binding.ivDogs)
    }
}