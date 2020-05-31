package com.example.cholti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cholti.adapters.CreatorAdapter
import com.example.cholti.data.Creator
import com.example.cholti.databinding.CreatorsListBinding

class CreatorsActivity : AppCompatActivity() {
    private lateinit var binding: CreatorsListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.creators_list
        )
        val creators: List<Creator> = listOf(
            Creator(
                profileName = "Rajwrita Nath",
                profileBio = "I paint and occasionally code.",
                githubID = "https://github.com/rajwrita",
                linkedInID = "https://www.linkedin.com/in/rajwrita-nath/",
                twitterID = "https://twitter.com/rajwrita",
                profilePicture = R.raw.raju
            ),
            Creator(
                profileName = "Ritwik Raha",
                profileBio = "Obsessed with saving the world from bad design!",
                githubID = "https://github.com/ritwikraha",
                linkedInID = "https://www.linkedin.com/in/ritwik-raha",
                twitterID = "https://twitter.com/RahaRitwik",
                profilePicture = R.raw.ritwik
            ),
            Creator(
                profileName = "Puja Roychowdhury",
                profileBio = "I sound like Google assistant.",
                githubID = "https://github.com/PujaRc",
                linkedInID = "https://www.linkedin.com/in/pujarc98",
                twitterID = "https://www.twitter.com/pleb_talks",
                profilePicture = R.raw.puja
            ),
            Creator(
                profileName = "Aritra Roy Gosthipaty",
                profileBio = "I search Stack Overflow a LOT!",
                githubID = "https://www.github.com/ariG23498",
                linkedInID = "https://www.linkedin.com/in/ariG23498",
                twitterID = "https://www.twitter.com/ariG23498",
                profilePicture = R.raw.aritra
            )
        )
        var viewManager: RecyclerView.LayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        var viewAdapter: RecyclerView.Adapter<*> =
            CreatorAdapter(creators, this)
        binding.creatorsRecyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
