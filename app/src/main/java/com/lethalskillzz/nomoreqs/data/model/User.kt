package com.lethalskillzz.nomoreqs.data.model

import android.annotation.SuppressLint
import com.lethalskillzz.nomoreqs.presentation.custom.utils.extensions.emptyString

/**
 * Created by ibrahimabdulkadir on 21/11/2017.
 */


@SuppressLint("ParcelCreator")
 data class User constructor(val name: String?,
                            val avatarUrl: String = emptyString,
                            val username: String?,
                            val location: String?)