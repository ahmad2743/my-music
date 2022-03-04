package com.esgi.mymusic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.esgi.mymusic.AlbumRankingAdapter.ViewHolder
import com.esgi.mymusic.domain.TrendingAlbum
import com.squareup.picasso.Picasso

class AlbumRankingAdapter(val context: Context, val myList: List<TrendingAlbum>, private val listener: onAlbumItemClickListener
) : RecyclerView.Adapter<ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var artistName: TextView
        var trackTitle: TextView
        var position: TextView
        var img: ImageView

        init {
            trackTitle = itemView.findViewById(R.id.track_title)
            artistName = itemView.findViewById(R.id.track_artist)
            position = itemView.findViewById(R.id.number_item)
            img = itemView.findViewById(R.id.track_image)
            img.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)

            }
        }
    }

    interface onAlbumItemClickListener{
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.track_ranking_rows_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var pos = position + 1
        holder.artistName.text = myList[position].strArtist
        holder.trackTitle.text = myList[position].strAlbum
        holder.position.text = pos.toString()
        Picasso.get().load(myList[position]?.strTrackThumb.toString()).into(holder.img)
    }

    override fun getItemCount(): Int {
        return myList.size
    }
}
