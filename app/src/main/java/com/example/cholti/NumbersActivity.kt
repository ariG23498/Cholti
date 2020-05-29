package com.example.cholti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bangla.CustomSnapHelper
import com.example.bangla.Word
import com.example.bangla.WordAdapter
import com.example.cholti.databinding.WordsListBinding

class NumbersActivity : AppCompatActivity() {
    private lateinit var binding: WordsListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.words_list)
        val words: MutableList<Word> = mutableListOf(
            Word(defaultWord = "One", bengaliWord = "এক", pronunciation = "EK", mediaResourceId = R.raw.numbers_one),
            Word(defaultWord = "Two", bengaliWord = "দুই", pronunciation = "DUI", mediaResourceId = R.raw.numbers_two),
            Word(defaultWord = "Three", bengaliWord = "তিন", pronunciation = "TEEN", mediaResourceId = R.raw.numbers_three),
            Word(defaultWord = "Four", bengaliWord = "চার", pronunciation = "CHAAR", mediaResourceId = R.raw.numbers_four),
            Word(defaultWord = "Five", bengaliWord = "পাঁচ", pronunciation = "PAA-CH", mediaResourceId = R.raw.numbers_five)
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
