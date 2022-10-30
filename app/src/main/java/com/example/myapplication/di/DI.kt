package com.example.myapplication.di

//import com.example.myapplication.BuildConfig
//import com.example.myapplication.data.ApiConstants
//import com.example.myapplication.data.MainRepository
//import com.example.myapplication.data.TmdbApi
//import com.example.myapplication.domain.Interactor
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor

//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import java.util.concurrent.TimeUnit

/**object DI {
    val mainModule = module {
        //Создаем репозиторий
        single { MainRepository() }
        //Создаем объект для получения данных из сети
        single<TmdbApi> {
            val okHttpClient = OkHttpClient.Builder()
                //Настраиваем таймауты для медленного интернета
                .callTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                //Добавляем логгер
                .addInterceptor(HttpLoggingInterceptor().apply {
                    if (BuildConfig.DEBUG) {
                        level = HttpLoggingInterceptor.Level.BASIC
                    }
                })
                .build()
            //Создаем ретрофит
            val retrofit = Retrofit.Builder()
                //Указываем базовый URL из констант
                .baseUrl(ApiConstants.BASE_URL)
                //Добавляем конвертер
                .addConverterFactory(GsonConverterFactory.create())
                //Добавляем кастомный клиент
                .client(okHttpClient)
                .build()
            //Создаем сам сервис с методами для запросов
            retrofit.create(TmdbApi::class.java)
        }
        //Создаем интректор
        single { Interactor(get(), get()) }
    }
}*/