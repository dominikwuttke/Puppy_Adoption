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

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.Puppy
import com.example.androiddevchallenge.Puppylists
import com.example.androiddevchallenge.ui.theme.typography
import com.example.androiddevchallenge.viewmodel.OverViewViewModel

@Composable
fun CreatePuppyList(puppyList: List<Puppy>) {
    val viewModel = viewModel<OverViewViewModel>()
    Column() {
        Text(text = "ADOPT A PUPPY", textAlign = TextAlign.Center, modifier = Modifier.padding(8.dp).fillMaxWidth(), style = typography.h1)

        LazyColumn(
            content = {
                items(puppyList) { puppy ->
                    Surface(
                        elevation = 8.dp,
                        modifier = Modifier
                            .padding(0.dp, 16.dp)
                            .clickable {
                                viewModel.puppySelected(puppy)
                            }
                    ) {
                        Column() {
                            PuppyName(puppyName = puppy.name)
                            PuppyPicture(puppyPictureId = puppy.pictureRes)
                            PuppyData(
                                puppyRace = puppy.race,
                                puppyAge = puppy.age
                            )
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun PuppyPicture(puppyPictureId: Int) {
    val res = painterResource(id = puppyPictureId)
    Image(
        painter = res, contentDescription = "",
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 0.dp)
    )
}

@Composable
fun PuppyName(puppyName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Row() {
            Text(text = puppyName, style = typography.h1)
        }
    }
}

@Composable
fun PuppyData(puppyRace: String, puppyAge: Int) {

    Text(
        text = "Race : $puppyRace", style = typography.h2,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 8.dp, 8.dp)
    )

    Text(
        text = "Age : $puppyAge Month", style = typography.h2,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 0.dp, 8.dp, 8.dp)
    )
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun PuppyExample() {
    Surface() {
        Column() {
            PuppyName(puppyName = Puppylists.puppyList[0].name)
            PuppyPicture(puppyPictureId = Puppylists.puppyList[0].pictureRes)
            PuppyData(
                puppyRace = Puppylists.puppyList[0].race,
                puppyAge = Puppylists.puppyList[0].age
            )
        }
    }
}
