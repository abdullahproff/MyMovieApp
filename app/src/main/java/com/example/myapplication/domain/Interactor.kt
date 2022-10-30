package com.example.myapplication.domain

import android.util.Log
import com.example.myapplication.data.*
import com.example.myapplication.data.entity.API.API_KEY
import com.example.myapplication.data.entity.TmdbResults
import com.example.myapplication.utils.Converter
import com.example.myapplication.viewmodel.HomeFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor(private val repo: MainRepository, private val retrofitService: TmdbApi) {
    //В конструктор мы будем передавать коллбэк из вьюмоделе, чтобы реагировать на то, когда фильмы будут получены
    //и страницу, котороую нужно загрузить (это для пагинации)
    fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallback) {
            Log.d("метод getFilms", callback.toString())
        retrofitService.getFilms(API_KEY, "ru-RU", page).enqueue(object : Callback<TmdbResults> {
            override fun onResponse(call: Call<TmdbResults>, response: Response<TmdbResults>) {
                //При успехе мы вызываем метод передаем onSuccess и в этот коллбэк список фильмов
                callback.onSuccess(Converter.convertApiListToDTOList(response.body()?.tmdbFilms))
                Log.d("успех", response.body().toString())
            }

            override fun onFailure(call: Call<TmdbResults>, t: Throwable) {
                //В случае провала вызываем другой метод коллбека
                callback.onFailure()
                Log.d("то что нужно", t.message.toString())
            }
        })
    }
}