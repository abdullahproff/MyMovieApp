package com.example.myapplication.utils

import com.example.myapplication.data.entity.TmdbFilm
import com.example.myapplication.domain.Film

object Converter {
    fun convertApiListToDTOList(list: List<TmdbFilm>?): List<Film> {
        val result = mutableListOf<Film>()
        list?.forEach {
            result.add(Film(
                title = it.title,
                poster = it.posterPath,
                description = it.overview,
                rating = it.voteAverage,
                isInFavorites = false
            ))
        }
        return result
    }
}