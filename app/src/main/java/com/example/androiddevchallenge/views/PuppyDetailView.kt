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
package com.example.androiddevchallenge.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.Puppy
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun PuppyDetail(puppy: Puppy) {

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            PuppyName(puppyName = puppy.name)
            PuppyPicture(puppyPictureId = puppy.pictureRes)
            PuppyData(puppyRace = puppy.race, puppyAge = puppy.age)
            PuppyDescription(description = puppy.description)
            Adoption(puppy = puppy)
        }
    }
}

@Composable
fun PuppyDescription(description: String) {
    Text(text = description, modifier = Modifier.padding(16.dp, 16.dp))
}

@Composable
fun Adoption(puppy: Puppy) {
    val text = "If you had ever wanted a little ${puppy.race} and ${puppy.name} has already won your heart, " +
        "this is your chance to adopt him! Just call us at 1-800-ADOPT-A-PUPPY and provide us with his number"
    Text(text = text, modifier = Modifier.padding(16.dp, 8.dp))
    Text(
        text = "HIS NUMBER : ${puppy.callNumber}", textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        style = typography.h2
    )
}
