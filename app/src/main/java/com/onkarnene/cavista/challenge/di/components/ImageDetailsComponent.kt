package com.onkarnene.cavista.challenge.di.components

import androidx.lifecycle.ViewModelStoreOwner
import com.onkarnene.cavista.challenge.adapters.CommentAdapter
import com.onkarnene.cavista.challenge.di.modules.ImageModule
import com.onkarnene.cavista.challenge.repositories.ImageRepository
import com.onkarnene.cavista.challenge.views.ImageDetailsActivity
import com.onkarnene.cavista.challenge.views.models.ImageDetailsViewModel
import dagger.BindsInstance
import dagger.Component

/**
 * Dagger component implementation for [ImageDetailsActivity]
 */
@Component(modules = [ImageModule::class])
interface ImageDetailsComponent {
	
	/**
	 * Inject [ImageDetailsActivity] instance into dagger component.
	 */
	fun injectImageDetailsActivity(imageDetailsActivity: ImageDetailsActivity)
	
	/**
	 * Provides [CommentAdapter] instance.
	 */
	fun getCommentAdapter(): CommentAdapter
	
	/**
	 * Provides [ImageDetailsViewModel] instance.
	 */
	fun getImageDetailsViewModel(): ImageDetailsViewModel
	
	/**
	 * Provides [ImageRepository] instance used by view model factory.
	 */
	fun getImageRepository(): ImageRepository
	
	@Component.Builder
	interface Builder {
		
		@BindsInstance
		fun withOwner(owner: ViewModelStoreOwner): Builder
		
		fun build(): ImageDetailsComponent
	}
}