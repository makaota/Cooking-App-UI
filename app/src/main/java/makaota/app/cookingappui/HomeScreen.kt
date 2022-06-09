package makaota.app.cookingappui

import android.os.Build
import android.os.ParcelFileDescriptor
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
            SearchTextField()
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
    modifier: Modifier = Modifier
) {

    Card(
        modifier.size(75.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Image(
                painter = painter,
                contentDescription = contentDescriptor,
                contentScale = ContentScale.Crop
            )
    }

}

@Composable
fun SearchTextField(){

    val textFieldState = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp),
        value = textFieldState.value,
        onValueChange = {
            textFieldState.value = it
        },
        placeholder = {
            Text(
                text = "Sate, Nasi Goreng",
                style = MaterialTheme.typography.h3
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "search" )
        },
        textStyle = MaterialTheme.typography.h3,
        enabled = true,
        singleLine = true,
        readOnly = false,
        maxLines = 1,
        shape = RoundedCornerShape(25.dp)
    )
}
