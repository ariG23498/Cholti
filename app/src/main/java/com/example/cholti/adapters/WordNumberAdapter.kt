package com.example.cholti.adapters

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cholti.data.Number
import com.example.cholti.R

class NumberViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val bengaliTextView: TextView = v.findViewById(R.id.bengaliTextView)
    val defaultTextView: TextView = v.findViewById(R.id.defaultTextView)
    val pronunciationTextView: TextView = v.findViewById(R.id.pronunciationTextView)
    val playButton: Button = v.findViewById(R.id.playButton)
    val numberText: TextView = v.findViewById(R.id.numberTextView)
}
class WordNumberAdapter(private val dataSet: MutableList<Number>) :
    RecyclerView.Adapter<NumberViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): NumberViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item_total_number, viewGroup, false)
        return NumberViewHolder(v)
    }
    override fun onBindViewHolder(viewHolder: NumberViewHolder, position: Int) {
        viewHolder.bengaliTextView.text = dataSet[position].bengaliWord
        viewHolder.defaultTextView.text = dataSet[position].defaultWord
        viewHolder.pronunciationTextView.text = dataSet[position].pronunciation
        viewHolder.numberText.text = dataSet[position].number
        viewHolder.playButton.setOnClickListener { v ->
            MediaPlayer.create(v.context,dataSet[position].mediaResourceId).apply {
                start()
                setOnCompletionListener { mp -> mp.release() }
            }
        }
    }
    override fun getItemCount() = dataSet.size
}