package com.cst.cstacademy2025unitbv.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cst.cstacademy2025unitbv.R
import com.cst.cstacademy2025unitbv.models.MediaModel
import com.cst.cstacademy2025unitbv.models.PodcastModel
import com.cst.cstacademy2025unitbv.models.VideoModel

class MediaListAdapter(
    private val mediaList: List<MediaModel>
) : RecyclerView.Adapter<MediaListAdapter.MediaItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_podcast, parent, false)
        return MediaItemViewHolder(view)
    }

    override fun getItemCount() = mediaList.count()

    override fun onBindViewHolder(holder: MediaItemViewHolder, position: Int) {
        val podcast = (mediaList.getOrNull(position) as? PodcastModel) ?: return
        holder.bind(podcast)
    }


    inner class PodcastItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(podcast: PodcastModel) {

            view.findViewById<TextView>(R.id.tv_title).text = podcast.title

        }
    }

    inner class VideoItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(video: VideoModel) {

            view.findViewById<TextView>(R.id.tv_title).text = video.title
            view.findViewById<TextView>(R.id.tv_description).text = video.description

        }
    }

    inner class PostItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(post: PostModel) {

            view.findViewById<TextView>(R.id.tv_title).text = post.title
            view.findViewById<ImageView>(R.id.imageView).apply {
                Glide.with(this.context)
                    .load(post.imageUrl)
                    .into(this)
            }
        }
    }


}