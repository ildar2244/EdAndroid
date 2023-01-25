package com.axdar.edandroid.mock

import android.content.Context
import com.axdar.edandroid.R
import java.net.URI

class UriValidator(
    private val context: Context
) {
    fun validate(uri: String): String {
        val resId: Int = when {
            isUrl(uri) -> R.string.url
            isFile(uri) -> R.string.file
            else -> R.string.nothing
        }
        return context.getString(resId)
    }

    fun isUrl(uri: String): Boolean {
        return "http" == URI.create(uri).scheme
    }

    fun isFile(uri: String): Boolean {
        return "file" == URI.create(uri).scheme
    }
}