package makaota.app.cookingappui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import kotlin.math.round

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier
            .background(color = Color(0xFAF0E6))// linen
            .fillMaxSize()
    ){
        Column {
            GreetingSection()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GreetingSection(
    name: String = "Makaota"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ){
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            val currentMonth = LocalDate.now().month
            val currentDay = LocalDate.now().dayOfMonth
            Text(
                text = "$currentDay $currentMonth",
                style =  MaterialTheme.typography.h3,
                fontSize = 9.sp
            )
            Text(
                text = "hi, $name",
                style =  MaterialTheme.typography.h1
            )

        }
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "profile image",
            modifier = Modifier
                .size(70.dp)
                .clip(RoundedCornerShape(10.dp))
            )
    }
}
