package com.esgi.mymusic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.esgi.mymusic.domain.Album
import com.esgi.mymusic.domain.Artist
import com.esgi.mymusic.domain.ArtistDetail
import com.squareup.picasso.Picasso
import java.security.AccessControlContext

class SearchedArtistAdapter(val context: Context, val listArtists: List<ArtistDetail>,):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM_TITLE) {
            var itemView = LayoutInflater.from(context).inflate(R.layout.search_title_row, parent, false)
            return TitleViewHolder(itemView)

        } else {
            var itemView = LayoutInflater.from(context).inflate(R.layout.search_artist_row, parent, false)
            return CellViewHolder(itemView)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TitleViewHolder) {
            holder.title.text = "Artistes"
        } else if (holder is CellViewHolder) {
            holder.artistName.text = listArtists[position].strArtist
            Picasso.get().load(listArtists[position]?.strArtistThumb.toString()).into(holder.img)
        }
    }

    override fun getItemCount(): Int {
        return listArtists.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return ITEM_TITLE
        } else {
            return ITEM_CELL
        }
    }

    companion object {
        const val ITEM_TITLE = 0
        const val ITEM_CELL = 1
    }

}

class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var title: TextView
    init {
        title = itemView.findViewById(R.id.searched_artist_name)
    }
}
class CellViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var artistName: TextView
    var img: ImageView
    init {
        artistName = itemView.findViewById(R.id.searched_artist_image)
        img = itemView.findViewById(R.id.searched_artist_name)
    }
}