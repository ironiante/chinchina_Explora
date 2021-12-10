package com.example.chinchinaexplora.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class sitioItem(
    @SerializedName("descripcion2")
    val descripcion2: String?,
    @SerializedName("Descripción")
    val descripción: String?,
    @SerializedName("indicacion")
    val indicacion: String?,
    @SerializedName("Nombre del lugar")
    val nombreDelLugar: String?,
    @SerializedName("Puntuación")
    val puntuación: Double?,
    @SerializedName("temperatura")
    val temperatura: String?,
    @SerializedName("urlpicture")
    val urlpicture: String?,
    @SerializedName("Latitud")
    val latitud: Double?,
    @SerializedName("Longitud")
    val longitud: Double?
): Serializable