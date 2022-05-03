package ru.gendalf13666.rickandmorty.Model.Retrofit

import retrofit2.http.GET
import retrofit2.http.Query
import ru.gendalf13666.rickandmorty.Model.Data.CharacterList

interface SimpleApi {

    @GET("api/character")
    suspend fun getCharacters(
        @Query("page")
        page: Int
    ): CharacterList

    @GET("api/character")
    suspend fun getCharactersByName(
        @Query("name")
        name: String
    ): CharacterList

    @GET("api/character")
    suspend fun getCharactersbyStatusAndGender(
        @Query("status")
        status: String,
        @Query("gender")
        gender: String,
        @Query("page")
        page: Int
    ): CharacterList

    @GET("api/character")
    suspend fun getCharactersByStatus(
        @Query("status")
        status: String,
        @Query("page")
        page: Int
    ): CharacterList

    @GET("api/character")
    suspend fun getCharactersByGender(
        @Query("gender")
        gender: String,
        @Query("page")
        page: Int
    ): CharacterList
}
