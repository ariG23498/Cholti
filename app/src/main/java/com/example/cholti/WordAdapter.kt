package com.example.bangla


import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cholti.R


class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val bengaliTextView: TextView = v.findViewById(R.id.bengaliTextView)
    val defaultTextView: TextView = v.findViewById(R.id.defaultTextView)
    val pronunciationTextView: TextView = v.findViewById(R.id.pronunciationTextView)
    val playButton: Button = v.findViewById(R.id.playButton)
}
class WordAdapter(private val dataSet: MutableList<Word>) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item_total, viewGroup, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bengaliTextView.text = dataSet[position].bengaliWord
        viewHolder.defaultTextView.text = dataSet[position].defaultWord
        viewHolder.pronunciationTextView.text = dataSet[position].pronunciation
        viewHolder.playButton.setOnClickListener { v ->
            MediaPlayer.create(v.context,dataSet[position].mediaResourceId).apply {
            start()
            setOnCompletionListener { mp -> mp.release() }
            }
        }
    }
    override fun getItemCount() = dataSet.size
}