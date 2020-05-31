package com.example.cholti

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.cholti.databinding.ActivityMainBinding
import com.google.android.material.card.MaterialCardView
import kotlin.math.log


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val wordsCard: MaterialCardView = binding.wordsCard
        val phrasesCard: MaterialCardView = binding.phrasesCards
        val numbersCard: MaterialCardView = binding.numbersCard
        val colorsCard: MaterialCardView = binding.colorsCard
        val logo: ImageView = binding.logoImageView
        Glide
            .with(this)
            .load(R.drawable.logo)
            .into(logo)

        Glide
            .with(this)
            .load(R.drawable.kotha)
            .into(binding.phrasesImageView)
        Glide
            .with(this)
            .load(R.drawable.nombor)
            .into(binding.numbersImageView)
        Glide
            .with(this)
            .load(R.drawable.shobdo)
            .into(binding.wordsImageView)
        Glide
            .with(this)
            .load(R.drawable.rong)
            .into(binding.colorsImageView)

        wordsCard.setOnClickListener {
            wordsCard.checkedIcon = null
            openWordsList()
        }
        phrasesCard.setOnClickListener {
            phrasesCard.checkedIcon = null
            openPhrasesList()
        }
        numbersCard.setOnClickListener {
            numbersCard.checkedIcon = null
            openNumbersList()
        }
        colorsCard.setOnClickListener {
            colorsCard.checkedIcon = null
            openColorsList()
        }

        logo.setOnClickListener {
        openCreatorsList()
        }
    }

    fun openCreatorsList(){
        val intent: Intent = Intent(this,
            CreatorsActivity::class.java)
        startActivity(intent)
    }

    fun openPhrasesList(){
        val intent: Intent = Intent(this,PhrasesActivity::class.java)
        startActivity(intent)

    }

    fun openNumbersList(){
        val intent: Intent = Intent(this,NumbersActivity::class.java)

        startActivity(intent)

    }

    fun openColorsList(){
        val intent: Intent = Intent(this,ColorsActivity::class.java)

        startActivity(intent)

    }

    fun openWordsList(){
        val intent: Intent = Intent(this,WordsActivity::class.java)
        startActivity(intent)

    }
}
