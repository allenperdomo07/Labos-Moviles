package com.example.laboratorio12.network.dto.register

import com.google.gson.annotations.SerializedName

data class RegisterResponse (
    @SerializedName("msg") val message: String
        )