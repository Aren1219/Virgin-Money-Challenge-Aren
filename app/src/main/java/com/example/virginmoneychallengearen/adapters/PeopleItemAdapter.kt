package com.example.virginmoneychallengearen.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.virginmoneychallengearen.R
import com.example.virginmoneychallengearen.databinding.ItemEmployeeBinding
import com.example.virginmoneychallengearen.model.people.PeopleItemModel
import com.example.virginmoneychallengearen.model.people.PeopleModel

class PeopleItemAdapter(
    val employeeList: PeopleModel,
    val context: Context
) : RecyclerView.Adapter<PeopleItemAdapter.EmployeeViewHolder>() {

    inner class EmployeeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val binding: ItemEmployeeBinding = ItemEmployeeBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_employee,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employeeList[position]
        Glide.with(context).load(employee.avatar).into(holder.binding.ivEmployeeAvatar)
        holder.binding.tvEmployeeName.text = "${employee.firstName} ${employee.lastName}"
        holder.binding.tvEmployeeId.text = employee.id
        holder.binding.tvEmployeeJobTitle.text = employee.jobtitle
        holder.itemView.setOnClickListener() {
//            var
//            employee.lastName
//            employee.email
        }
    }

    override fun getItemCount(): Int = employeeList.size

//    private val onItemClickListener: ((PeopleItemModel)->Unit)? = null
//    fun setOnItemClickListener(listener:(PeopleItemModel)->Unit){
//        listener
//    }
}