package com.euphony.waple.common

import android.widget.Toast
import androidx.annotation.StringRes
import com.euphony.waple.WapleApplication

object ToastUtils {

    fun showToast(@StringRes msgId: Int) {
        Toast.makeText(
            WapleApplication.getContext(),
            msgId,
            Toast.LENGTH_SHORT
        ).show()

        fun showToast(msg: String?) {
            Toast.makeText(
                WapleApplication.getContext(),
                msgId,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}