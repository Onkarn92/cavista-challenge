package com.onkarnene.cavista.challenge.di.components

import androidx.lifecycle.ViewModelStoreOwner
import com.onkarnene.cavista.challenge.adapters.CommentAdapter
import com.onkarnene.cavista.challenge.di.modules.ImageModule
import com.onkarnene.cavista.challenge.views.ImageDetailsActivity
import com.onkarnene.cavista.challenge.views.models.ImageDetailsViewModel
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ImageModule::class])
interface ImageDetailsComponent {
	
	fun injectImageDetailsActivity(imageDetailsActivity: ImageDetailsActivity)
	
	fun getCommentAdapter(): CommentAdapter
	
	fun getImageDetailsViewModel(): ImageDetailsViewModel
	
	@Component.Builder
	interface Builder {
		
		@BindsInstance
		fun withOwner(owner: ViewModelStoreOwner): Builder
		
		fun build(): ImageDetailsComponent
	}
}