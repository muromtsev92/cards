package com.cardsapp.cards.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cardsapp.cards.R
import com.cardsapp.cards.model.Noun

class NounItemAdapter: RecyclerView.Adapter<NounItemAdapter.NounItemViewHolder>() {
    var data = listOf<Noun>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : NounItemViewHolder = NounItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: NounItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size

    class NounItemViewHolder(val rootView: TextView): RecyclerView.ViewHolder(rootView){
        companion object {
            fun inflateFrom(parent: ViewGroup): NounItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.noun_item, parent, false) as TextView
                return NounItemViewHolder(view)
            }
        }
        fun bind(item: Noun) {
            rootView.text = """${item.article.toString().lowercase()} ${item.germanSingular} - die ${item.germanPlural} - ${item.russian}"""
        }
    }
}