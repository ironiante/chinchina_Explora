package com.example.chinchinaexplora.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class sitioItem(
    @SerializedName("Descripción")
    val descripción: String,
    @SerializedName("Nombre del lugar")
    val nombreDelLugar: String,
    @SerializedName("Puntuación")
    val puntuación: Double,
    @SerializedName("urlpicture")
    val urlpicture: String
): Serializable
