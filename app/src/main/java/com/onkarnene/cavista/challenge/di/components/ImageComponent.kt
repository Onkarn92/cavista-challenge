package com.onkarnene.cavista.challenge.di.components

import androidx.lifecycle.ViewModelStoreOwner
import com.onkarnene.cavista.challenge.adapters.ImageGridAdapter
import com.onkarnene.cavista.challenge.di.modules.ImageModule
import com.onkarnene.cavista.challenge.views.SearchActivity
import com.onkarnene.cavista.challenge.views.models.SearchActivityViewModel
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ImageModule::class])
interface ImageComponent {
	
	fun injectSearchActivity(searchActivity: SearchActivity)
	
	fun getImageGridAdapter(): ImageGridAdapter
	
	fun getViewModel(): SearchActivityViewModel
	
	@Component.Builder
	interface Builder {
		
		@BindsInstance
		fun withCallback(callback: ImageGridAdapter.Callback): Builder
		
		@BindsInstance
		fun withOwner(owner: ViewModelStoreOwner): Builder
		
		fun build(): ImageComponent
	}
}