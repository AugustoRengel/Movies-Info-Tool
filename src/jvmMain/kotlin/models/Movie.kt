package models

import kotlinx.serialization.Serializable

@Serializable
class Movie(
    val title: String,
    val image: String,
    val year: Int,
    val imDbRating: Double)
{


}