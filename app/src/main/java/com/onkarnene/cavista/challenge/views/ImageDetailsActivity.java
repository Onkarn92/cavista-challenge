package com.onkarnene.cavista.challenge.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.onkarnene.cavista.challenge.ExtensionsKt;
import com.onkarnene.cavista.challenge.R;
import com.onkarnene.cavista.challenge.adapters.CommentAdapter;
import com.onkarnene.cavista.challenge.databinding.ActivityImageDetailsBinding;
import com.onkarnene.cavista.challenge.models.Image;
import com.onkarnene.cavista.challenge.utilities.Utils;
import com.onkarnene.cavista.challenge.views.models.Factory;
import com.onkarnene.cavista.challenge.views.models.ImageDetailsViewModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

public class ImageDetailsActivity extends AppCompatActivity {
	
	private static final String KEY_IMAGE = "key_image";
	private ActivityImageDetailsBinding m_binding;
	private Image m_image;
	private CommentAdapter m_commentAdapter = new CommentAdapter();
	private ImageDetailsViewModel m_imageDetailsViewModel;
	
	public static Intent newInstance(@NonNull Context context, @NonNull Image image) {
		return new Intent(context, ImageDetailsActivity.class).putExtra(KEY_IMAGE, image);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		m_binding = ActivityImageDetailsBinding.inflate(getLayoutInflater());
		setContentView(m_binding.getRoot());
		m_image = getIntent().getParcelableExtra(KEY_IMAGE);
		if (m_image == null) {
			Toast.makeText(this, R.string.err_something_went_wrong, Toast.LENGTH_SHORT)
			     .show();
			finish();
			return;
		}
		m_imageDetailsViewModel = new ViewModelProvider(this, new Factory()).get(ImageDetailsViewModel.class);
		setupView();
		attachObservers();
	}
	
	@Override
	public boolean onOptionsItemSelected(@NonNull final MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			onBackPressed();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void setupView() {
		final ActionBar actionBar = getSupportActionBar();
		if (actionBar != null) {
			actionBar.setDisplayHomeAsUpEnabled(true);
			actionBar.setDisplayShowTitleEnabled(true);
			actionBar.setTitle(TextUtils.isEmpty(m_image.getTitle()) ? m_image.getId() : m_image.getTitle());
		}
		Glide.with(this)
		     .load(m_image.getLink())
		     .placeholder(R.drawable.placeholder_image)
		     .error(R.drawable.placeholder_image)
		     .into(m_binding.image);
		
		m_binding.commentRecycler.setLayoutManager(new LinearLayoutManager(this));
		m_binding.commentRecycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
		m_binding.commentRecycler.setAdapter(m_commentAdapter);
		m_binding.commentTextInput.setEndIconOnClickListener(view -> {
			if (ExtensionsKt.isValidInput(m_binding.commentEdit, m_binding.commentTextInput, Utils.INSTANCE.getString(R.string.err_invalid_input))) {
				//noinspection ConstantConditions
				m_image.getComments()
				       .add(m_binding.commentEdit.getText()
				                                 .toString());
				m_imageDetailsViewModel.saveImageWithComments(m_image);
				m_binding.commentEdit.getText()
				                     .clear();
				ExtensionsKt.hideKeyboard(m_binding.commentEdit);
			}
		});
		final String count = String.format(Utils.INSTANCE.getString(R.string.comment_count), 0);
		m_binding.commentCountText.setText(count);
	}
	
	private void attachObservers() {
		m_imageDetailsViewModel.getImageById(m_image.getId())
		                       .observe(this, image -> {
			                       if (image != null) {
				                       final String count = String.format(Utils.INSTANCE.getString(R.string.comment_count), image.getComments()
				                                                                                                                 .size());
				                       m_binding.commentCountText.setText(count);
				                       m_commentAdapter.setItems(image.getComments());
			                       }
		                       });
	}
}