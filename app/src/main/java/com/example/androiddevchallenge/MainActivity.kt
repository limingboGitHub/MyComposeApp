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
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.ui.theme.MyTheme

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
    Surface(
        color = Color.LightGray,
        modifier = Modifier.fillMaxWidth()) {

        val puppies = listOf(
            "Golden retriever",
            "Pug",
            "Teddy",
            "Shepherd",
            "Shiba inu",
            "Poodle")
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally){
            items(puppies){
                ItemLayout(it)
            }
        }
    }
}

@Composable
fun ItemLayout(puppy:String){

    ConstraintLayout(
        Modifier
            .padding(5.dp)
            .background(Color.White)) {
        val (image,text) = createRefs()

        val imagePainter = painterResource(R.drawable.puppy_01)
        Image(
            imagePainter,"",
            Modifier
                .width(200.dp)
                .wrapContentHeight()
                .constrainAs(image) {
                    top.linkTo(parent.top, margin = 10.dp)
                })

        Text(
            puppy,
            Modifier.constrainAs(text){
                top.linkTo(image.bottom,margin = 10.dp)
            })
    }



}

private fun getPuppies():List<Puppy>{
    return listOf(
        Puppy("Golden retriever",10,"F"),
        Puppy("Pug",10,"F"),
        Puppy("Teddy",10,"F"),
        Puppy("Shepherd",10,"F"),
        Puppy("Shiba inu",10,"F"),
        Puppy("Poodle",10,"F"),
    )
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
