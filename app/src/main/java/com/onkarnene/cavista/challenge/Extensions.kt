package com.onkarnene.cavista.challenge

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.lifecycle.Lifecycle.State
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.onkarnene.cavista.challenge.utilities.Utils

fun LifecycleOwner.isAtLeastStarted(): Boolean = this.lifecycle.currentState.isAtLeast(State.STARTED)

fun LifecycleOwner.isAtLeastCreated(): Boolean = this.lifecycle.currentState.isAtLeast(State.CREATED)

fun LifecycleOwner.isDestroyed(): Boolean = this.lifecycle.currentState == State.DESTROYED

/**
 * Show keyboard and request focus for this [EditText].
 */
@Suppress("DEPRECATION")
fun EditText.showKeyboard() {
	val keyboard = App.getContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
	this.requestFocus()
	Handler().postDelayed({keyboard?.showSoftInput(this, 0)}, 200)
}

/**
 * Hide keyboard, But keep the focus for this [EditText] as it is.
 */
fun EditText.hideKeyboard() {
	val keyboard = App.getContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
	keyboard?.hideSoftInputFromWindow(this.windowToken, 0)
}

/**
 * Check if inputted [TextInputEditText.getText] is null/empty or not.
 *
 * @param parent [TextInputLayout] instance to be examined.
 * @param errorMsg as inputted by user.
 *
 * @return true if input is valid, non-empty and non-null, otherwise false.
 */
fun TextInputEditText.isValidInput(
		parent: TextInputLayout,
		errorMsg: String = Utils.getString(R.string.err_invalid_input)
): Boolean = if (!this.text?.toString().isNullOrBlank()) {
	parent.isErrorEnabled = false
	true
} else {
	parent.error = errorMsg
	this.showKeyboard()
	false
}

/**
 * Start the new [Activity] and finish the calling one.
 */
fun Activity.startAndFinish(intent: Intent) {
	startActivity(intent)
	finish()
}