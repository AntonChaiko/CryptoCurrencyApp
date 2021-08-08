package com.example.data.models

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class UserEntity(
    val userEmail: String?,
    val userName: String?,
    val userImage: Uri?
) : Parcelable