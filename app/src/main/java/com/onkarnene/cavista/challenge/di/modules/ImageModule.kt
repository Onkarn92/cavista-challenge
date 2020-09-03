package com.onkarnene.cavista.challenge.di.modules

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.onkarnene.cavista.challenge.adapters.ImageGridAdapter
import com.onkarnene.cavista.challenge.views.models.Factory
import com.onkarnene.cavista.challenge.views.models.SearchActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class ImageModule {
	
	@Provides
	fun provideImageGridAdapter(callback: ImageGridAdapter.Callback): ImageGridAdapter = ImageGridAdapter(callback)
	
	@Provides
	fun provideSearchActivityViewModel(owner: ViewModelStoreOwner): SearchActivityViewModel {
		return ViewModelProvider(owner, Factory())[SearchActivityViewModel::class.java]
	}
}