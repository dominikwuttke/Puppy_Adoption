package com.example.androiddevchallenge.views


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.Puppy
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.typography
import com.example.androiddevchallenge.viewmodel.OverViewViewModel


@Composable
fun CreatePuppyList(puppyList : List<Puppy>){
    val viewModel = viewModel<OverViewViewModel>()
            LazyColumn(content = {
                items(puppyList){ puppy ->
                    Surface(elevation = 8.dp,modifier = Modifier
                        .padding(0.dp, 16.dp)
                        .clickable {
                            viewModel.puppySelected(puppy)
                        }){
                        Column() {
                            PuppyName(puppyName = puppy.name)
                            PuppyPicture(puppyPictureId = puppy.pictureRes)
                            PuppyData( puppyRace = puppy.race,
                                puppyAge = puppy.age)
                        }
                    }
                }
            })
}

@Composable
fun PuppyPicture(puppyPictureId : Int){
    val res = painterResource(id = puppyPictureId)
    Image(painter =  res, contentDescription = "",modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp, 0.dp))
}


@Composable
fun PuppyName(puppyName: String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),horizontalArrangement = Arrangement.SpaceEvenly) {
        Row() {
            Text(text = puppyName,style = typography.h1)
        }
    }
}

@Composable
fun PuppyData( puppyRace:String, puppyAge: Int){


            Text(text = "Race : $puppyRace",style = typography.h2,modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp,8.dp,8.dp))


            Text(text = "Age : $puppyAge Month",style = typography.h2,modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp,0.dp,8.dp,8.dp))



    
}


@Preview(widthDp = 360, heightDp = 640)
@Composable
fun puppyExample(){
    Surface() {
        Column() {
            PuppyName(puppyName = "Fluffy")
            PuppyPicture(puppyPictureId = R.drawable.puppy_1)
            PuppyData( puppyRace = "Libanese", puppyAge = 8)
        }
    }

}