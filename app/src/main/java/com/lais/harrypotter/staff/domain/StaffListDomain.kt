package com.lais.harrypotter.staff.domain

import androidx.annotation.DrawableRes
import com.lais.harrypotter.R
import com.lais.harrypotter.characters.data.response.WandResponse
import com.lais.harrypotter.characters.domain.Ancestry
import com.lais.harrypotter.characters.domain.House
import com.lais.harrypotter.characters.domain.mapToAncestry
import com.lais.harrypotter.characters.domain.mapToHouse
import com.lais.harrypotter.staff.data.response.StaffResponse

class StaffListDomain {
    fun mapToPresentation(staff: List<StaffResponse>): List<StaffPresentation> {
        return staff
            .filter { item -> item.image.isNotEmpty() }
            .map { item ->
                StaffPresentation(
                    name = item.name,
                    imageUrl = item.image,
                    ancestry = mapToAncestry(item.ancestry),
                    yearOfBirth = item.yearOfBirth,
                    patronus = item.patronus,
                    wand = item.wand,
                    house = mapToHouse(item.house)
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

data class StaffPresentation(
    val name: String,
    val imageUrl: String,
    val ancestry: Ancestry,
    val yearOfBirth: Int,
    val patronus: String,
    val house: House,
    val wand: WandResponse
)

