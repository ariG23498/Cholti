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

class PhrasesActivity : AppCompatActivity() {
    private lateinit var binding: WordsListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.words_list)
        val categoryText: TextView = binding.categoryTextView
        categoryText.text = "PHRASES"
        Glide
            .with(this)
            .load(R.drawable.kotha)
            .into(binding.categoryImageView)
        val words: MutableList<Word> = mutableListOf(
            Word(defaultWord = "Thank you", bengaliWord = "ধন্যবাদ", pronunciation = "DHO-NNO-BAAD", mediaResourceId = R.raw.phrases_thankyou),
            Word(defaultWord = "How are you", bengaliWord = "আপনি কেমন আছেন", pronunciation = "AAPNI-KEMON-ACHEN", mediaResourceId = R.raw.phrases_howareyou),
            Word(defaultWord = "I am fine", bengaliWord = "আমি ভাল আছি", pronunciation = "AMI-BHALO-ACHI", mediaResourceId = R.raw.phrases_iamfine),
            Word(defaultWord = "Very nice", bengaliWord = "খুব সুন্দর", pronunciation = "KHUB-SHUNDOR", mediaResourceId = R.raw.phrases_verynice),
            Word(defaultWord = "See you again", bengaliWord = "আবার দেখা হবে", pronunciation = "ABAR-DEKHA-HOBE", mediaResourceId = R.raw.phrases_seeyouagain)
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
