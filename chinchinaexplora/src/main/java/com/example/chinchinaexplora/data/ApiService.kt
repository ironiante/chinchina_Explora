package com.example.chinchinaexplora.data

import com.example.chinchinaexplora.model.sitio
import retrofit2.http.GET

interface ApiService {

    @GET ("ironiante/chinchina_Explora/data")
    suspend fun getsitio(): sitio
}

