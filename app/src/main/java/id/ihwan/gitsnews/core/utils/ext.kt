package id.ihwan.gitsnews.core.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Activity.showWait() = LoadingDialog.show(this)

fun hideWait() = LoadingDialog.dismiss()

fun Activity.hideKeyboard() {
    val view = currentFocus ?: View(this)
    val imm: InputMethodManager? =
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm?.hideSoftInputFromWindow(view.windowToken, 0)
}