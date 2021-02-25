package com.example.androiddevchallenge

import androidx.navigation.NavType
import java.io.Serializable

data class Puppy(
    val pictureRes : Int,
    val name : String,
    val race : String,
    val age : Int,
    val callNumber : Int,
    val description : String

) : Serializable
