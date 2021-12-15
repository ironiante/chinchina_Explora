package com.example.chinchinaexplora.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class sitioItem(
    @SerializedName("descripcion2")
    val descripcion2: String,
    @SerializedName("Descripción")
    val descripción: String,
    @SerializedName("indicacion")
    val indicacion: String,
    @SerializedName("latitud")
    val latitud: Double,
    @SerializedName("longitud")
    val longitud: Double,
    @SerializedName("Nombre del lugar")
    val nombreDelLugar: String,
    @SerializedName("Puntuación")
    val puntuación: Double,
    @SerializedName("temperatura")
    val temperatura: String,
    @SerializedName("urlpicture")
    val urlpicture: String
):Serializable