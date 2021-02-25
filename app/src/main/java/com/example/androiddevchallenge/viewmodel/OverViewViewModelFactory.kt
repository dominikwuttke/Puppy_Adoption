package com.example.androiddevchallenge.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController

class OverViewViewModelFactory(private val navHostController: NavHostController) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OverViewViewModel::class.java))
            return OverViewViewModel(navHostController) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}