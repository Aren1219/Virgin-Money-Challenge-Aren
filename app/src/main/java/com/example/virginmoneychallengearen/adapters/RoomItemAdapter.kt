package com.example.virginmoneychallengearen.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoneychallengearen.R
import com.example.virginmoneychallengearen.databinding.ItemRoomBinding
import com.example.virginmoneychallengearen.model.rooms.RoomItemModel

class RoomItemAdapter(
    val roomList: List<RoomItemModel>,
    val context: Context
): RecyclerView.Adapter<RoomItemAdapter.RoomViewHolder>(){

    inner class RoomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ItemRoomBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        return RoomViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_room,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val room = roomList[position]
        holder.binding.tvRoomId.text = "Room: ${room.id}"
        if (room.isOccupied==true){
            holder.binding.tvRoomOccupied.text = "Occupied"
        }else{
            holder.binding.tvRoomOccupied.text = "Vacant"
        }
//        holder.binding.tvRoomTime.text = room.createdAt
        holder.binding.tvRoomMaxOccupancy.text = "Max Occupancy: ${room.maxOccupancy}"
    }

    override fun getItemCount(): Int = roomList.size

}