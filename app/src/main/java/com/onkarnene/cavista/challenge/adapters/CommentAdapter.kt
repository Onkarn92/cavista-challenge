package com.onkarnene.cavista.challenge.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.onkarnene.cavista.challenge.R
import com.onkarnene.cavista.challenge.adapters.CommentAdapter.ViewHolder
import com.onkarnene.cavista.challenge.databinding.ItemCommentBinding

class CommentAdapter : RecyclerView.Adapter<ViewHolder>() {
	
	private val items: ArrayList<String> = arrayListOf()
	
	override fun onCreateViewHolder(
			parent: ViewGroup,
			viewType: Int
	): ViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false))
	
	override fun onBindViewHolder(
			holder: ViewHolder,
			position: Int
	) {
		holder.setData(items[position])
	}
	
	override fun getItemCount(): Int = items.size
	
	fun setItems(comments: ArrayList<String>) {
		items.clear()
		items.addAll(comments)
		notifyDataSetChanged()
	}
	
	class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		
		private val binding: ItemCommentBinding = ItemCommentBinding.bind(itemView)
		
		fun setData(comment: String) {
			binding.commentText.text = comment
		}
	}
}