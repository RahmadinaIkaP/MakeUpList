package binar.academy.makeuplist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.academy.makeuplist.databinding.ItemMakeupBinding
import binar.academy.makeuplist.model.ResponseMakeUpItem
import com.bumptech.glide.Glide

class MakeUpAdapter(var listMakeUp : List<ResponseMakeUpItem>) : RecyclerView.Adapter<MakeUpAdapter.ViewHolder>() {

    inner class ViewHolder(var binding : ItemMakeupBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(makeup : ResponseMakeUpItem){
            binding.apply {
                tvNamaBrand.text = makeup.brand
                tvNamaMakeUp.text = makeup.name
                Glide.with(itemView)
                    .load(makeup.imageLink)
                    .into(ivMakeUp)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemMakeupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listMakeUp[position])
    }

    override fun getItemCount(): Int = listMakeUp.size
}