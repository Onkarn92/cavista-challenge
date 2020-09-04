package com.onkarnene.cavista.challenge.di.components

import androidx.lifecycle.ViewModelStoreOwner
import com.onkarnene.cavista.challenge.adapters.ImageGridAdapter
import com.onkarnene.cavista.challenge.di.modules.ImageModule
import com.onkarnene.cavista.challenge.repositories.ImageRepository
import com.onkarnene.cavista.challenge.views.SearchActivity
import com.onkarnene.cavista.challenge.views.models.SearchActivityViewModel
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ImageModule::class])
interface SearchComponent {
	
	fun injectSearchActivity(searchActivity: SearchActivity)
	
	fun getImageGridAdapter(): ImageGridAdapter
	
	fun getViewModel(): SearchActivityViewModel
	
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