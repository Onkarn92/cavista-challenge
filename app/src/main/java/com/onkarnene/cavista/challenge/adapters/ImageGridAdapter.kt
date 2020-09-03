package com.onkarnene.cavista.challenge.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.onkarnene.cavista.challenge.R
import com.onkarnene.cavista.challenge.adapters.ImageGridAdapter.ViewHolder
import com.onkarnene.cavista.challenge.databinding.ItemImageBinding
import com.onkarnene.cavista.challenge.models.Image

class ImageGridAdapter(private val callback: Callback) : RecyclerView.Adapter<ViewHolder>() {
	
	private val images: ArrayList<Image> = arrayListOf()
	
	override fun onCreateViewHolder(
			parent: ViewGroup,
			viewType: Int
	): ViewHolder {
		val holder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false))
		holder.binding.root.setOnClickListener {
			if (holder.imageModel != null) {
				callback.onImageClick(holder.imageModel!!)
			}
		}
		return holder
	}
	
	override fun onBindViewHolder(
			holder: ViewHolder,
			position: Int
	) {
		holder.setData(images[position])
	}
	
	override fun getItemCount(): Int = images.size
	
	fun setItems(items: ArrayList<Image>) {
		images.clear()
		images.addAll(items)
		notifyDataSetChanged()
	}
	
	class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		
		val binding: ItemImageBinding = ItemImageBinding.bind(itemView)
		
		var imageModel: Image? = null
		
		fun setData(image: Image) {
			imageModel = image
			Glide.with(itemView).load(image.link).centerCrop().placeholder(R.drawable.placeholder_image).error(R.drawable.placeholder_image)
					.into(binding.image)
		}
	}
	
	interface Callback {
		
		fun onImageClick(image: Image)
	}
}