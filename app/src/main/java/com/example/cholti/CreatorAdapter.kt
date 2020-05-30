package com.example.cholti

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val profileName: TextView = v.findViewById(R.id.profileNameTextView)
    val profileBio: TextView = v.findViewById(R.id.profileBioTextView)
    val profilePicture: ImageView = v.findViewById(R.id.profileImageView)
    val githubId: ImageView = v.findViewById(R.id.githubImageView)
    val linkedInId: ImageView = v.findViewById(R.id.linkedInImageView)
    val twitterId: ImageView = v.findViewById(R.id.twitterImageView)
}
class CreatorAdapter(private val dataSet: List<Creator>, private val mcontext: Context) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.creator_list_item, viewGroup, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.profileName.text = dataSet[position].profileName
        viewHolder.profileBio.text = dataSet[position].profileBio
        Glide.with(mcontext).load(dataSet[position].profilePicture).into(viewHolder.profilePicture)

        viewHolder.githubId.setOnClickListener {
            val intent =  Intent(Intent.ACTION_VIEW, Uri.parse(dataSet[position].githubID))
            mcontext.startActivity(intent)
        }

        viewHolder.linkedInId.setOnClickListener {
            val intent =  Intent(Intent.ACTION_VIEW, Uri.parse(dataSet[position].linkedInID))
            mcontext.startActivity(intent)
        }

        viewHolder.twitterId.setOnClickListener {
            val intent =  Intent(Intent.ACTION_VIEW, Uri.parse(dataSet[position].twitterID))
            mcontext.startActivity(intent)
        }
    }
    override fun getItemCount() = dataSet.size
}

fun calculateInSampleSize(options: BitmapFactory.Options, reqWidth: Int, reqHeight: Int): Int {
    // Raw height and width of image
    val (height: Int, width: Int) = options.run { outHeight to outWidth }
    var inSampleSize = 1

    if (height > reqHeight || width > reqWidth) {

        val halfHeight: Int = height / 2
        val halfWidth: Int = width / 2

        // Calculate the largest inSampleSize value that is a power of 2 and keeps both
        // height and width larger than the requested height and width.
        while (halfHeight / inSampleSize >= reqHeight && halfWidth / inSampleSize >= reqWidth) {
            inSampleSize *= 2
        }
    }

    return inSampleSize
}