package com.onkarnene.cavista.challenge.views

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.onkarnene.cavista.challenge.R
import com.onkarnene.cavista.challenge.adapters.ImageGridAdapter
import com.onkarnene.cavista.challenge.adapters.ImageGridAdapter.Callback
import com.onkarnene.cavista.challenge.databinding.ActivitySearchBinding
import com.onkarnene.cavista.challenge.di.components.DaggerSearchComponent
import com.onkarnene.cavista.challenge.hideKeyboard
import com.onkarnene.cavista.challenge.isValidInput
import com.onkarnene.cavista.challenge.models.Image
import com.onkarnene.cavista.challenge.utilities.Utils
import com.onkarnene.cavista.challenge.views.models.SearchActivityViewModel
import kotlinx.android.synthetic.main.activity_search.*
import javax.inject.Inject

/**
 * Gallery search view container.
 */
class SearchActivity : AppCompatActivity(), Callback {
	
	private lateinit var binding: ActivitySearchBinding
	
	@Inject lateinit var viewModel: SearchActivityViewModel
	@Inject lateinit var adapter: ImageGridAdapter
	
	companion object {
		
		private const val KEY_QUERY = "key_query"
	}
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivitySearchBinding.inflate(layoutInflater)
		setContentView(binding.root)
		// Initialising the dagger component to inject all dependencies.
		DaggerSearchComponent.builder().withCallback(this).withOwner(this).build().injectSearchActivity(this)
		setupView(savedInstanceState?.getString(KEY_QUERY))
		attachObservers()
	}
	
	override fun onSaveInstanceState(outState: Bundle) {
		// Saving current search query text to handle orientation change.
		outState.putString(KEY_QUERY, searchEdit.text.toString())
		super.onSaveInstanceState(outState)
	}
	
	override fun onImageClick(image: Image) {
		// Trigger click event of particular image.
		if (!image.id.isBlank()) {
			startActivity(ImageDetailsActivity.newInstance(this, image))
		}
	}
	
	/**
	 * Setup a view for [SearchActivity] container.
	 */
	private fun setupView(existingQuery: String?) {
		supportActionBar?.setDisplayShowTitleEnabled(true)
		supportActionBar?.setTitle(R.string.gallery)
		with(binding) {
			searchEdit.setText(existingQuery)
			searchEdit.hideKeyboard()
			searchTextInput.setEndIconOnClickListener {
				// Trigger when search icon gets clicked.
				if (searchEdit.isValidInput(searchTextInput, Utils.getString(R.string.err_invalid_input))) {
					imageRecycler.visibility = View.GONE
					progress.visibility = View.VISIBLE
					errorLayout.root.visibility = View.GONE
					viewModel.dispatchQueryText(query = searchEdit.text.toString())
					searchEdit.hideKeyboard()
				}
			}
			imageRecycler.layoutManager = GridLayoutManager(this@SearchActivity, 4, GridLayoutManager.VERTICAL, false)
			imageRecycler.adapter = adapter
		}
	}
	
	/**
	 * Observe all existing and new images and load it into adapter, as well as observer corresponding errors.
	 */
	private fun attachObservers() {
		viewModel.getImageObservable().observe(this) {
			with(binding) {
				imageRecycler.visibility = View.VISIBLE
				progress.visibility = View.GONE
				errorLayout.root.visibility = View.GONE
			}
			adapter.setItems(it)
		}
		viewModel.getErrorObservable().observe(this) {pair ->
			with(binding) {
				imageRecycler.visibility = View.GONE
				progress.visibility = View.GONE
				errorLayout.root.visibility = View.VISIBLE
				errorLayout.errorTitleText.text = pair.first
				errorLayout.errorMessageText.text = pair.second.localizedMessage
			}
		}
	}
}