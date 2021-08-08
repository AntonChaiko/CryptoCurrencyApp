package com.example.data.mapper

import com.example.data.models.UserEntity
import com.example.domain.UserDto


fun userDtoToEntity(userDto: UserDto): UserEntity {
    return UserEntity(
        userEmail = userDto.userEmail,
        userImage = userDto.userImage,
        userName = userDto.userName
    )
}

fun userEntityToDto(userEntity: UserEntity): UserDto {
    return UserDto(
        userEmail = userEntity.userEmail,
        userImage = userEntity.userImage,
        userName = userEntity.userName
    )
}