package com.example.myapplication

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.amsdevelops.filmssearch.Film
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.film_item.view.*
import kotlinx.android.synthetic.main.fragments_film_item.view.*
import kotlinx.android.synthetic.main.film_item.view.title as title1
import kotlinx.android.synthetic.main.fragments_film_item.view.description as description1
import kotlinx.android.synthetic.main.fragments_film_item.view.poster as poster1

//В конструктор класс передается layout, который мы создали(film_item.xml)
class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //Привязываем view из layout к переменным
    private val title = itemView.title
    private val poster = itemView.poster
    private val description = itemView.description

    //В этом методе кладем данные из film в наши view
    fun bind(film: Film) {
        //Устанавливаем заголовок
        title.text = film.title
        //Устанавливаем постер
        //Указываем контейнер, в которм будет "жить" наша картинка
        Glide.with(itemView)
            //Загружаем сам ресурс
            .load(film.poster)
            //Центруем изображение
            .centerCrop()
            //Указываем ImageView, куда будем загружать изображение
            .into(poster)
        //Устанавливаем описание
        description.text = film.description
    }
}