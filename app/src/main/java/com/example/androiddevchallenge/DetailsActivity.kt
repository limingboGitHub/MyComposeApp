package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.PuppyDetails
import com.example.androiddevchallenge.viewmodel.DetailsViewModel

class DetailsActivity : AppCompatActivity(){

    val detailsViewModel : DetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getIntExtra("id",0)

        detailsViewModel.puppyDetails.observe(this){
            setContent {
                activityLayout(it)
            }
        }
        detailsViewModel.getDetails(id)
    }
}

fun Context.lookDetails(id:Int){
    startActivity(Intent(this,DetailsActivity::class.java)
        .apply {
            putExtra("id",id)
        })
}

@Composable
fun activityLayout(puppyDetails: PuppyDetails) {
    val buttonEnable = remember{ mutableStateOf(true) }

    Column( Modifier
        .padding(10.dp)) {
        
        Button(
            onClick = {
                buttonEnable.value = !buttonEnable.value
            },
            enabled = buttonEnable.value,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (buttonEnable.value) MaterialTheme.colors.primary else Color.Gray
            )) {
            Text(if (buttonEnable.value) "Adpot it" else "Thank you")
        }

        detailsLayout(puppyDetails)
    }

}

@Composable
private fun detailsLayout(
    puppyDetails: PuppyDetails
) {
    val state = rememberScrollState()

    Column(
        Modifier
            .padding(10.dp)
            .verticalScroll(state), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val imagePainter = painterResource(getPuppyImageRes(puppyDetails.name))
        Image(
            imagePainter, "",
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(4.dp))
        )

        Row(
            Modifier.padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                puppyDetails.name,
                style = MaterialTheme.typography.h6
            )

            val sexImagePainter =
                painterResource(if (puppyDetails.sex == "M") R.drawable.male else R.drawable.female)
            Image(
                sexImagePainter, "",
                Modifier
                    .width(24.dp)
                    .padding(start = 5.dp)
            )
        }

        Text(
            "${puppyDetails.age} days",
            Modifier
                .padding(top = 2.dp)
        )

        Text(
            puppyDetails.introduction,
            Modifier
                .padding(top = 2.dp),
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview(name = "details")
@Composable
fun detailsPreview(){
    activityLayout(PuppyDetails(0,"Golden retriever",10,"M","The Golden Retriever is a medium-large gun dog that was bred to retrieve shot waterfowl, such as ducks and upland game birds, during hunting and shooting parties. The name \"retriever\" refers to the breed's ability to retrieve shot game undamaged due to their soft mouth. Golden retrievers have an instinctive love of water, and are easy to train to basic or advanced obedience standards. They are a long-coated breed, with a dense inner coat that provides them with adequate warmth in the outdoors, and an outer coat that lies flat against their bodies and repels water. Golden retrievers are well suited to residency in suburban or country environments. They shed copiously, particularly at the change of seasons, and require fairly regular grooming. The Golden Retriever was originally bred in Scotland in the mid-19th century"))
}