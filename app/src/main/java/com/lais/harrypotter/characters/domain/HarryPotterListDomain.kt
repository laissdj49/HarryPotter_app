package com.lais.harrypotter.characters.domain

import androidx.annotation.DrawableRes
import com.lais.harrypotter.R
import com.lais.harrypotter.characters.data.response.HarryPotterCharactersResponse
import com.lais.harrypotter.characters.data.response.WandResponse

class HarryPotterListDomain {

    fun mapToPresentation(
        characters: List<HarryPotterCharactersResponse>
    ): List<HarryPotterPresentation> {
        return characters
            .filter { item -> item.image.isNotEmpty() }
            .map { item ->
                HarryPotterPresentation(
                    name = item.name,
                    imageUrl = item.image,
                    house = mapToHouse(item.house),
                    ancestry = mapToAncestry(item.ancestry),
                    yearOfBirth = item.yearOfBirth,
                    patronus = item.patronus,
                    wand = item.wand
                )
            }
    }
}

fun mapToHouse(house: String): House {
    return when (house) {
        "Gryffindor" -> House.Gryffindor
        "Slytherin" -> House.Slytherin
        "Hufflepuff" -> House.Hufflepuff
        "Ravenclaw" -> House.Ravenclaw
        else -> House.Unknown
    }
}

fun mapToAncestry(ancestry: String): Ancestry {
    return when (ancestry) {
        "half-blood" -> Ancestry.HalfBlood
        "pure-blood" -> Ancestry.PureBlood
        else -> Ancestry.Muggleborn
    }
}

//fun mapToWand(wood: String, core: String,length: Double ):WandResponse {
  // return WandResponse(wood, core, length)
//}



data class HarryPotterPresentation(
    val name: String,
    val imageUrl: String,
    val house: House,
    val ancestry: Ancestry,
    val yearOfBirth: Int,
    val patronus: String,
    val wand: WandResponse
)

enum class House(@DrawableRes val icon: Int? = null) {
    Gryffindor(icon = R.drawable.gryffindor),
    Slytherin(icon = R.drawable.slytherin),
    Hufflepuff(icon = R.drawable.hufflepuff),
    Ravenclaw(icon = R.drawable.ravenclaw),
    Unknown,
}

enum class Ancestry {
    HalfBlood,
    Muggleborn,
    PureBlood,
}