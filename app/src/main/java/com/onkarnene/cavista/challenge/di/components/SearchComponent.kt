package com.onkarnene.cavista.challenge.di.components

import androidx.lifecycle.ViewModelStoreOwner
import com.onkarnene.cavista.challenge.adapters.ImageGridAdapter
import com.onkarnene.cavista.challenge.di.modules.ImageModule
import com.onkarnene.cavista.challenge.repositories.ImageRepository
import com.onkarnene.cavista.challenge.views.SearchActivity
import com.onkarnene.cavista.challenge.views.models.SearchActivityViewModel
import dagger.BindsInstance
import dagger.Component

/**
 * Dagger component implementation for [SearchActivity]
 */
@Component(modules = [ImageModule::class])
interface SearchComponent {
	
	/**
	 * Inject [SearchActivity] instance into dagger component.
	 */
	fun injectSearchActivity(searchActivity: SearchActivity)
	
	/**
	 * Provides [ImageGridAdapter] instance.
	 */
	fun getImageGridAdapter(): ImageGridAdapter
	
	/**
	 * Provides [SearchActivityViewModel] instance.
	 */
	fun getViewModel(): SearchActivityViewModel
	
	/**
	 * Provides [ImageRepository] instance used by view model factory.
	 */
	fun getImageRepository(): ImageRepository
	
	@Component.Builder
	interface Builder {
		
		@BindsInstance
		fun withCallback(callback: ImageGridAdapter.Callback): Builder
		
		@BindsInstance
		fun withOwner(owner: ViewModelStoreOwner): Builder
		
		fun build(): SearchComponent
	}
}