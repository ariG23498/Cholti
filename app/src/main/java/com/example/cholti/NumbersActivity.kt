package com.example.cholti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bangla.CustomSnapHelper
import com.example.cholti.adapters.WordNumberAdapter
import com.example.cholti.data.Number
import com.example.cholti.databinding.WordsListBinding

class NumbersActivity : AppCompatActivity() {
    private lateinit var binding: WordsListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.words_list)
        val categoryText: TextView = binding.categoryTextView
        categoryText.text = "NUMBERS"
        Glide
            .with(this)
            .load(R.drawable.nombor)
            .into(binding.categoryImageView)
        val words: MutableList<Number> = mutableListOf(
            Number(
                defaultWord = "One",
                bengaliWord = "এক",
                pronunciation = "EK",
                mediaResourceId = R.raw.numbers_one,
                number = "১"
            ),
            Number(
                defaultWord = "Two",
                bengaliWord = "দুই",
                pronunciation = "DUI",
                mediaResourceId = R.raw.numbers_two,
                number = "২"
            ),
            Number(
                defaultWord = "Three",
                bengaliWord = "তিন",
                pronunciation = "TEEN",
                mediaResourceId = R.raw.numbers_three,
                number = "৩"
            ),
            Number(
                defaultWord = "Four",
                bengaliWord = "চার",
                pronunciation = "CHAAR",
                mediaResourceId = R.raw.numbers_four,
                number = "৪"
            ),
            Number(
                defaultWord = "Five",
                bengaliWord = "পাঁচ",
                pronunciation = "PAA-CH",
                mediaResourceId = R.raw.numbers_five,
                number = "৫"
            )
        )

        val snapHelper: CustomSnapHelper = CustomSnapHelper()
        var viewManager: RecyclerView.LayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        var viewAdapter: RecyclerView.Adapter<*> =
            WordNumberAdapter(words)

        var recyclerView: RecyclerView = binding.wordsRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }
        snapHelper.attachToRecyclerView(recyclerView)
    }
}
