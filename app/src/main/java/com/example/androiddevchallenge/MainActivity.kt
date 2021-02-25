/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.viewmodel.OverViewViewModel
import com.example.androiddevchallenge.viewmodel.OverViewViewModelFactory
import com.example.androiddevchallenge.views.CreatePuppyList
import com.example.androiddevchallenge.views.PuppyDetail
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {

                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "OverView") {

            composable("OverView") {

                viewModel<OverViewViewModel>(factory = OverViewViewModelFactory(navController))
                CreatePuppyList(Puppylists.puppyList)
            }
            composable(
                "detailscreen/{puppy}",
                arguments = listOf(
                    navArgument("puppy") {

                        type = NavType.StringType/*NavType.SerializableType(Puppy::class.java)*/
                    }
                )
            ) {
                val args = it.arguments?.getString("puppy")
                val puppy = Gson().fromJson(args, Puppy::class.java)

                PuppyDetail(puppy)
            }
        }

        // Text(text = "Ready... Set... GOOOOOOO!")
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
