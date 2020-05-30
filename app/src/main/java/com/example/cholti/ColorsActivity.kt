package com.example.cholti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bangla.CustomSnapHelper
import com.example.bangla.Word
import com.example.bangla.WordAdapter
import com.example.cholti.databinding.WordsListBinding

class ColorsActivity : AppCompatActivity() {
    private lateinit var binding: WordsListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.words_list)
        val categoryText: TextView = binding.categoryTextView
        categoryText.text = "COLORS"
        Glide
            .with(this)
            .load(R.drawable.rong)
            .into(binding.categoryImageView)
        val words: MutableList<Word> = mutableListOf(
            Word(defaultWord = "Red", bengaliWord = "লাল", pronunciation = "LAAL", mediaResourceId = R.raw.colours_red),
            Word(defaultWord = "Green", bengaliWord = "সবুজ", pronunciation = "SHO-BUJ", mediaResourceId = R.raw.colours_green),
            Word(defaultWord = "Blue", bengaliWord = "নীল", pronunciation = "NEEL", mediaResourceId = R.raw.colours_blue),
            Word(defaultWord = "Black", bengaliWord = "কালো", pronunciation = "KALO", mediaResourceId = R.raw.colours_black),
            Word(defaultWord = "White", bengaliWord = "সাদা", pronunciation = "SHADA", mediaResourceId = R.raw.colours_white)
        )

        val snapHelper: CustomSnapHelper = CustomSnapHelper()
        var viewManager: RecyclerView.LayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        var viewAdapter: RecyclerView.Adapter<*> = WordAdapter(words)

        var recyclerView: RecyclerView = binding.wordsRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }
        snapHelper.attachToRecyclerView(recyclerView)

    }
}
