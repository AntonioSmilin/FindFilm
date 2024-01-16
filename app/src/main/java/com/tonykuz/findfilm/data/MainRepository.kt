package com.tonykuz.findfilm.data

import com.tonykuz.findfilm.R
import com.tonykuz.findfilm.domain.Film

class MainRepository {
    val filmsDataBase = listOf(
        Film(
            "Список Шиндлера",
            R.drawable.schindlerslist,
            "In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.",
            7.7f
        ),
        Film(
            "Бойцовский клуб",
            R.drawable.fightclub,
            "An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.",
            9.3f
        ),
        Film(
            "Начало",
            R.drawable.inception,
            "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.",
            8.0f
        ),
        Film(
            "Матрица",
            R.drawable.matrix,
            "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.",
            9.0f
        ),
        Film(
            "Семь",
            R.drawable.se7en,
            "Two detectives, a rookie and a veteran, hunt a serial killer who uses the seven deadly sins as his motives.",
            8.5f
        ),
        Film(
            "Интерстеллар",
            R.drawable.interstellar,
            "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.",
            8.2f
        ),
        Film(
            "Зелёная миля",
            R.drawable.greenmile,
            "A tale set on death row in a Southern jail, where gentle giant John possesses the mysterious power to heal people's ailments. When the lead guard, Paul, recognizes John's gift, he tries to help stave off the condemned man's execution.",
            7.4f
        ),
        Film(
            "Терминатор 2: Судный день",
            R.drawable.terminator2,
            "A cyborg, identical to the one who failed to kill Sarah Connor, must now protect her ten year old son John from an even more advanced and powerful cyborg.",
            2.3f
        ),
        Film(
            "Паразиты",
            R.drawable.parasite,
            "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.",
            8.1f
        ),
        Film(
            "Король Лев",
            R.drawable.lionking,
            "Lion prince Simba and his father are targeted by his bitter uncle, who wants to ascend the throne himself.",
            4.5f
        )
    )
}