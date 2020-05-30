package com.example.cholti

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.cholti.databinding.ActivityMainBinding
import com.google.android.material.card.MaterialCardView


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
            .load(R.drawable.kotha)
            .into(findViewById(R.id.phrasesImageView))
        Glide
            .with(this)
            .load(R.drawable.nombor)
            .into(findViewById(R.id.numbersImageView))
        Glide
            .with(this)
            .load(R.drawable.shobdo)
            .into(findViewById(R.id.wordsImageView))
        Glide
            .with(this)
            .load(R.drawable.rong)
            .into(findViewById(R.id.colorsImageView))

        wordsCard.setOnClickListener {
            wordsCard.isChecked = !wordsCard.isChecked
            phrasesCard.isChecked = false
            numbersCard.isChecked = false
            colorsCard.isChecked = false
        }
        phrasesCard.setOnClickListener {
            wordsCard.isChecked = false
            phrasesCard.isChecked = !phrasesCard.isChecked
            numbersCard.isChecked = false
            colorsCard.isChecked = false
        }
        numbersCard.setOnClickListener {
            wordsCard.isChecked = false
            phrasesCard.isChecked = false
            numbersCard.isChecked = !numbersCard.isChecked
            colorsCard.isChecked = false
        }
        colorsCard.setOnClickListener {
            wordsCard.isChecked = false
            phrasesCard.isChecked = false
            numbersCard.isChecked = false
            colorsCard.isChecked = !colorsCard.isChecked
        }

        val goButton: Button = binding.goButton
        goButton.setOnClickListener {
            if (wordsCard.isChecked) openWordsList()
            else if (colorsCard.isChecked) openColorsList()
            else if (numbersCard.isChecked) openNumbersList()
            else if (phrasesCard.isChecked) openPhrasesList()
            else Toast.makeText(this, "None Selected", Toast.LENGTH_SHORT).show()
            wordsCard.isChecked = false
            colorsCard.isChecked = false
            phrasesCard.isChecked = false
            numbersCard.isChecked = false
        }

        logo.setOnClickListener {
        openCreatorsList()
        }
    }

    fun openCreatorsList(){
        val intent: Intent = Intent(this,CreatorsActivity::class.java)
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
