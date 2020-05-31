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
import com.example.cholti.adapters.WordColorAdapter
import com.example.cholti.data.Color
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
        val words: MutableList<Color> = mutableListOf(
            Color(defaultWord = "Red", bengaliWord = "লাল", pronunciation = "LAAL", mediaResourceId = R.raw.colours_red, red = 255, green = 0, blue = 0),
            Color(defaultWord = "Green", bengaliWord = "সবুজ", pronunciation = "SHO-BUJ", mediaResourceId = R.raw.colours_green, red = 0, green = 255, blue = 0),
            Color(defaultWord = "Blue", bengaliWord = "নীল", pronunciation = "NEEL", mediaResourceId = R.raw.colours_blue, red = 0, green = 0, blue = 255),
            Color(defaultWord = "Black", bengaliWord = "কালো", pronunciation = "KALO", mediaResourceId = R.raw.colours_black, red = 0, green = 0, blue = 0),
            Color(defaultWord = "White", bengaliWord = "সাদা", pronunciation = "SHADA", mediaResourceId = R.raw.colours_white, red = 255, green = 255, blue = 255)
        )

        val snapHelper: CustomSnapHelper = CustomSnapHelper()
        var viewManager: RecyclerView.LayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        var viewAdapter: RecyclerView.Adapter<*> = WordColorAdapter(words)

        var recyclerView: RecyclerView = binding.wordsRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }
        snapHelper.attachToRecyclerView(recyclerView)

    }
}
