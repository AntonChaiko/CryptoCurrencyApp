package com.example.domain

import android.net.Uri

data class UserDto(
    val userImage: Uri?,
    val userName: String?,
    val userEmail:String?
)