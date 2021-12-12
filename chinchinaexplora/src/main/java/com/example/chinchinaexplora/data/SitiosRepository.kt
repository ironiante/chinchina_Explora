package com.example.chinchinaexplora.data

class SitiosRepository {

    suspend fun getsitio () = ApiFactory.retrofit.getsitio()
}