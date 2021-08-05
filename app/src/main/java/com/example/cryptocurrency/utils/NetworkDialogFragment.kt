package com.example.cryptocurrency.utils

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.cryptocurrency.R

class NetworkDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity.let {
            val builder = AlertDialog.Builder(it)
                .setIcon(R.drawable.ic_wifi_off)
            builder.setTitle("No internet connection")
                .setPositiveButton("Ok") { dialog, _ ->
                    dialog.cancel()
                }.create()
        }

    }
    companion object {
        const val TAG = "NetworkConnectionDialog"
    }
}