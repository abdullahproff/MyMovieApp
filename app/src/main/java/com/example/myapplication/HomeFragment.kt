package com.amsdevelops.filmssearch

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private val filmsDataBase = listOf(
        Film("The Raiders of the Lost Ark", R.drawable.poster_1, "In 1936, American archaeologist Indiana Jones recovers a golden idol from a booby-trapped Peruvian temple. Rival archaeologist René Belloq corners him and steals the idol; Jones escapes in a waiting seaplane. After returning to the United States, Jones is briefed by two Army Intelligence agents that Nazi German forces are excavating at Tanis, Egypt, and one of their telegrams mentions Jones' old mentor Abner Ravenwood. Jones deduces that the Nazis seek the Ark of the Covenant, which Adolf Hitler believes will make their army invincible. The agents recruit Jones to recover the Ark first."),
        Film("Jaws", R.drawable.poster_2, "American thriller film directed by Steven Spielberg, based on the 1974 novel by Peter Benchley. It stars Roy Scheider as police chief Martin Brody who, with the help of a marine biologist (Richard Dreyfuss) and a professional shark hunter (Robert Shaw), hunts a man-eating great white shark that is attacking beachgoers at a summer resort town."),
        Film("Coming to America", R.drawable.poster_3, "In the wealthy African nation of Zamunda, crown prince Akeem Joffer grows weary of his pampered lifestyle on his 21st birthday and wishes to do more for himself. When his parents, King Jaffe and Queen Aoleon, present him with an arranged bride-to-be, Akeem takes action. Seeking an independent woman who loves him for himself and not his social status, Akeem and his best friend/personal aide, Semmi, travel to the New York City borough of Queens and rent a squalid tenement in the neighborhood of Long Island City under the guise of poor foreign students."),
        Film("Independence Day", R.drawable.poster_4, "On July 2, 1996, an enormous extraterrestrial mothership enters Earth's orbit and deploys multiple saucers, each 15 miles (24 kilometers) wide, over major cities worldwide, including New York City, Los Angeles and Washington, D.C."),
        Film("New Jack City", R.drawable.poster_5, "American crime thriller film based upon an original story and written by Thomas Lee Wright and Barry Michael Cooper, and directed by Mario Van Peebles in his feature film directorial debut as he also co-stars in the film."),
        Film("E.T.", R.drawable.poster_6, "American science fiction film produced and directed by Steven Spielberg and written by Melissa Mathison. It tells the story of Elliott, a boy who befriends an extraterrestrial dubbed E.T., who is left behind on Earth. Along with his friends and family, Elliott must find a way to help E.T. return home while avoiding the government."),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //находим наш RV
        main_recycler.apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
                override fun click(film: Film) {
                    (requireActivity() as MainActivity).launchDetailsFragment(film)
                }
            })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        //Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)
    }

}