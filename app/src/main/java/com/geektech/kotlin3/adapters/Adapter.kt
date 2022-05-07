package com.geektech.kotlin3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.geektech.kotlin3.databinding.ItemRamBinding

class Adapter(private  val onItemAdd: (Int) -> Unit,
              private  val onItemDelete: (Int) -> Unit) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var listImage = arrayListOf<Int>()
    fun setList(listImage: ArrayList<Int>){
        this.listImage = listImage
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding= ItemRamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listImage[position])

    }
    override fun getItemCount(): Int = listImage.size
    inner class ViewHolder(private  val binding: ItemRamBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            i: Int) {
            binding.image.setImageResource(listImage[adapterPosition])
            binding.image.setOnClickListener{
                if (binding.background.isInvisible){
                    binding.background.isVisible = true
                    onItemAdd(i)
                }
                else{
                    binding.background.isInvisible = true
                    onItemDelete(i)
                }
            }
        }
    }
}
