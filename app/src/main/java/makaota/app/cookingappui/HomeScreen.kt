package makaota.app.cookingappui

import android.os.Build
import android.os.ParcelFileDescriptor
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import kotlin.math.round

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen() {


    Box(
        modifier = Modifier
            .background(color = Color(0xFAF0E6))// linen
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            //ProfileImage(
            //  painter = painter,
            //contentDescriptor = contentDescriptor)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun GreetingSection(
    name: String = "Makaota"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            val currentMonth = LocalDate.now().month
            val currentDay = LocalDate.now().dayOfMonth
            Text(
                text = "$currentDay $currentMonth",
                style = MaterialTheme.typography.h3,
                fontSize = 9.sp
            )
            Text(
                text = "Hi, $name",
                style = MaterialTheme.typography.h1
            )

        }

            val painter = painterResource(id = R.drawable.makaota_profile_img) // profile image
            val contentDescriptor = "image"// content Description

            ProfileImage(painter = painter, contentDescriptor = contentDescriptor)


    }
}

@Composable
fun ProfileImage(
    painter: Painter,
    contentDescriptor: String,
    modifier: Modifier = Modifier)

{
        Card(
            modifier.size(75.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        )

        {
            Image(
                painter = painter,
                contentDescription = contentDescriptor,
                contentScale = ContentScale.Crop
            )
//            Row(modifier = modifier.padding(top = 2.dp, start = 50.dp)) {
//                Image(
//                    painter = painterResource(R.drawable.ic_red_circle),
//                    contentDescription = "",
//                    modifier = modifier
//                        .size(20.dp)
//
//                )
//            }
        }



}
