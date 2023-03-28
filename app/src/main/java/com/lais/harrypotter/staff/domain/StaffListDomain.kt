package com.lais.harrypotter.staff.domain

import androidx.annotation.DrawableRes
import com.lais.harrypotter.R
import com.lais.harrypotter.characters.domain.Ancestry
import com.lais.harrypotter.characters.domain.House
import com.lais.harrypotter.characters.domain.mapToAncestry
import com.lais.harrypotter.characters.domain.mapToHouse
import com.lais.harrypotter.staff.data.response.StaffResponse

class StaffListDomain {
    fun mapToPresentation(staff: List<StaffResponse>): List<Unit> {
        return staff
            .filter { item -> item.image.isNotEmpty() }
            .map { item ->
                StaffPresentation(
                    name = item.name,
                    imageUrl = item.image,
                    ancestry = mapToAncestry(item.ancestry)


                )
            }
    }
}

data class StaffPresentation(
    val name: String,
    val imageUrl: String,
    val ancestry: Ancestry
)

