package com.esgi.mymusic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.esgi.mymusic.domain.ArtistDetail
import com.squareup.picasso.Picasso

class FavoriteArtistsAdapter(val context: Context, private val favoriteArtistsList: List<ArtistDetail>,
    private val favoriteArtistListener: FavoriteArtistsAdapter.onItemClickListener) : RecyclerView.Adapter<FavoriteArtistsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var artistImage: ImageView
        var artistName: TextView

        init {
            artistImage = itemView.findViewById(R.id.favorite_artist_image)
            artistName = itemView.findViewById(R.id.favorite_artist_name)
            artistName.setOnClickListener(this)
        }


        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                favoriteArtistListener.onItemClick(position)
            }
        }

    }

    interface ArtistItemListener {
        fun onArtistSelected(artist: ArtistDetail)
    }

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.favorite_artist_row, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var pos = position + 1
        holder.artistName.text = favoriteArtistsList[position].strArtist
        Picasso.get().load(favoriteArtistsList[position]?.strArtistLogo.toString()).into(holder.artistImage)
    }

    override fun getItemCount(): Int {
        return favoriteArtistsList.size
    }
}