package com.esgi.mymusic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.esgi.mymusic.domain.Track


class ListViewAdapter(val context: Context, val myList: List<Track>):
    RecyclerView.Adapter<ListViewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var trackNb: TextView
        var trackTitle: TextView

        init {
            trackTitle = itemView.findViewById(com.esgi.mymusic.R.id.album_piste_title)
            trackNb = itemView.findViewById(com.esgi.mymusic.R.id.album_title_nb)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewAdapter.ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.list_view_row, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewAdapter.ViewHolder, position: Int) {
        var pos = position + 1
        holder.trackTitle.text = myList[position].strTrack
        holder.trackNb.text = pos.toString()  
    }

    override fun getItemCount(): Int {
        return myList.size
    }


}

