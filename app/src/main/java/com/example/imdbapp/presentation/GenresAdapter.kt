package com.example.imdbapp.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imdbapp.databinding.PopularGenresItemBinding
import com.example.imdbapp.domain.entities.PopularGenresEntity

class GenresAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var context: Context
    private val items: MutableList<PopularGenresEntity> = mutableListOf()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PopularGenresViewHolder(PopularGenresItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item =items[position]
        (holder as PopularGenresViewHolder).bind(item.genreName)
    }

    fun addItems(popularGenresList: List<PopularGenresEntity>) {
        val newIndex = items.size
        val newItemsCount = popularGenresList.size
        if (items.addAll(popularGenresList)) notifyItemRangeInserted(newIndex, newItemsCount)
    }

    inner class PopularGenresViewHolder(private val viewBinding: PopularGenresItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(name: String?) {
            viewBinding.tv.text = name?:""
        }
    }

}