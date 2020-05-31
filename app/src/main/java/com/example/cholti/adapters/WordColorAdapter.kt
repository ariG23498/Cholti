package com.example.cholti.adapters

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cholti.R
import com.example.cholti.data.Color

class ColorViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val bengaliTextView: TextView = v.findViewById(R.id.bengaliTextView)
    val defaultTextView: TextView = v.findViewById(R.id.defaultTextView)
    val pronunciationTextView: TextView = v.findViewById(R.id.pronunciationTextView)
    val playButton: Button = v.findViewById(R.id.playButton)
    val colorImage: ImageView = v.findViewById(R.id.colorImage)
}
class WordColorAdapter(private val dataSet: MutableList<Color>) :
    RecyclerView.Adapter<ColorViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ColorViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item_total_color, viewGroup, false)
        return ColorViewHolder(v)
    }
    override fun onBindViewHolder(viewHolder: ColorViewHolder, position: Int) {
        viewHolder.bengaliTextView.text = dataSet[position].bengaliWord
        viewHolder.defaultTextView.text = dataSet[position].defaultWord
        viewHolder.pronunciationTextView.text = dataSet[position].pronunciation
        viewHolder.colorImage.setBackgroundColor(android.graphics.Color.rgb(
            dataSet[position].red,
            dataSet[position].green,
            dataSet[position].blue))
        viewHolder.playButton.setOnClickListener { v ->
            MediaPlayer.create(v.context,dataSet[position].mediaResourceId).apply {
                start()
                setOnCompletionListener { mp -> mp.release() }
            }
        }
    }
    override fun getItemCount() = dataSet.size
}