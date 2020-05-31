package com.example.cholti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bangla.CustomSnapHelper
import com.example.cholti.data.Word
import com.example.bangla.WordAdapter
import com.example.cholti.databinding.WordsListBinding

class WordsActivity : AppCompatActivity() {
    private lateinit var binding: WordsListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.words_list)
        val categoryText: TextView = binding.categoryTextView
        categoryText.text = "WORDS"
        Glide
            .with(this)
            .load(R.drawable.shobdo)
            .into(binding.categoryImageView)
        val words: MutableList<Word> = mutableListOf(
            Word(defaultWord = "Yes", bengaliWord = "হ্যাঁ", pronunciation = "HAAN", mediaResourceId = R.raw.words_yes),
            Word(defaultWord = "No", bengaliWord = "না", pronunciation = "NAA", mediaResourceId = R.raw.words_no),
            Word(defaultWord = "Probably", bengaliWord = "সম্ভবত", pronunciation = "SHOM-BHO-BOTO", mediaResourceId = R.raw.words_perhaps),
            Word(defaultWord = "Where", bengaliWord = "কোথায়", pronunciation = "KOTHAYE", mediaResourceId = R.raw.words_where),
            Word(defaultWord = "When", bengaliWord = "কখন", pronunciation = "KOKHON", mediaResourceId = R.raw.words_when)
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
