package com.example.androiddevchallenge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.Puppy
import com.google.gson.Gson

class OverViewViewModel(navHostController: NavHostController) : ViewModel() {

    private val navController = navHostController

    fun puppySelected(puppy : Puppy) {
        val puppySerialize = Gson().toJson(puppy)
        navController.navigate("detailscreen/$puppySerialize")
    }




}