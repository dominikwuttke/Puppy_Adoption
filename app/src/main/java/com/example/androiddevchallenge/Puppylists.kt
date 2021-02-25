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

object Puppylists {

    private val felix = Puppy(
        R.drawable.siberian_husky_puppy, "Felix", "Siberian Husky", 6, 1356,
        "Felix is a little Husky who lost his home just recently due to some consequences coming from the " +
            "weather. He likes to run around and play in the snow. If you are living in a cold zone, where it snows " +
            "it would just be like coming home for him"
    )

    private val fluffy = Puppy(
        R.drawable.chihuahua, "Fluffy", "Chihuahua", 1, 23,
        "Fluffy is a very young Chihuahua, she is the child of two street dogs. Her mother died at her " +
            "birth and she was found by some passengers, who heard her crying and brought her to the shelter. " +
            "She was still in a good condition and is now seeking for a lovely home to begin her new life. Will " +
            "you take care of this sweet little dog"
    )

    private val bessy = Puppy(
        R.drawable.labrador, "Bessy", "Labrador", 3, 513,
        "Bessy came recently to us and was brought by her former owner. They just couldn't take care " +
            "of her,because the owners are getting divorced. Can you help Bessy find a new home and hopefully for " +
            "the rest of her life"
    )

    private val goldy = Puppy(
        R.drawable.golden_retriever, "Goldy", "Golden Retriever", 5, 8456,
        "Goldy was found on the streets by one of our workers, she seems to be abandoned. We don't want her " +
            "to get used to the life in the shelter, will you come and rescue this sweet little dog"
    )
    val puppyList = listOf(felix, fluffy, bessy, goldy)
}
