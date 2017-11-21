package com.lethalskillzz.nomoreqs.presentation.custom.utils.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri


inline fun Context.actionView(url: () -> String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url()))
    startActivity(intent)
}