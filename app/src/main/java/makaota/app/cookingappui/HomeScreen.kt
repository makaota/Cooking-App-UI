package makaota.app.cookingappui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import makaota.app.cookingappui.ui.theme.*
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen() {


    BoxWithConstraints(
        modifier = Modifier
            .background(color = Color((0xE9DCC9)))// linen
            .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            SearchTextField()
            ChefSection(
                chefImages = listOf(
                    ChefImage(
                        name = "Leonardo", R.drawable.leonardo, ""
                    ),
                    ChefImage(name = "Nomzamo", R.drawable.nomzamo, ""),
                    ChefImage(name = "Bristol", R.drawable.bristol, ""),
                    ChefImage(name = "Pravan", R.drawable.pravan, ""),
                    ChefImage(name = "Putin", R.drawable.putin, "")
                )
            )
            JustForYouSection(
                recipesImages = listOf(
                    JustForYou(
                        name = "Quick and Easy Braai Broodjies",
                        R.drawable.quick_and_easy_braaibroodjies
                    ),
                    JustForYou(
                        name = "Lamp Chops with Peach Caprese Salad",
                        R.drawable.lamp_chops_with_peach_caprese_salad
                    )
                )
            )
        }
        BottomMenu(
            item = listOf(
                BottomMenuContent("", R.drawable.ic_home),
                BottomMenuContent("", R.drawable.ic_chart),
                BottomMenuContent("", R.drawable.ic_favorite),
                BottomMenuContent("", R.drawable.ic_person)
            ), modifier = Modifier.align(Alignment.BottomCenter)
        )


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
fun SearchTextField() {

    val textFieldState = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        value = textFieldState.value,
        onValueChange = {
            textFieldState.value = it
        },

        placeholder = {
            Text(
                text = "Sate, Nasi Goreng",
                style = MaterialTheme.typography.h3,
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "search",
            )
        },
        textStyle = MaterialTheme.typography.h3,

        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Magenta,
            unfocusedBorderColor = Color((0xE9DCC9))// linen
        ),
        shape = RoundedCornerShape(25.dp)
    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChefSection(chefImages: List<ChefImage>) {

    val title: String = "Best Chef"
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "$title",
                style = MaterialTheme.typography.h1
            )

        }

        Text(
            text = "See all",
            style = MaterialTheme.typography.body1,
            textDecoration = TextDecoration.Underline
        )

    }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            LazyRow(
                //  cells = GridCells.Fixed(1),
                contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(chefImages.size) {
                    ChefItem(chefImage = chefImages[it])
                    Spacer(modifier = Modifier.width(15.dp))

                }
            }
        }
    }

}

@Composable
fun ChefItem(chefImage: ChefImage) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
    ) {
        Card(
            Modifier.size(80.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        ) {
            Image(
                painter = painterResource(id = chefImage.image),
                contentDescription = chefImage.description
            )

        }

        Text(
            text = chefImage.name,
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .align(Alignment.BottomCenter)

        )

    }

}


@Composable
fun JustForYouSection(recipesImages: List<JustForYou>) {
    val title = "Just For You"

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center)
        {

            Text(
                text = title,
                style = MaterialTheme.typography.h1
            )

        }
        Text(
            text = "See all",
            style = MaterialTheme.typography.body1,
            textDecoration = TextDecoration.Underline
        )
    }

    BoxWithConstraints(
        //  Modifier.MaxHeight()
    )
    {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        {

            Column(verticalArrangement = Arrangement.SpaceBetween) {
                LazyRow(
                    //  cells = GridCells.Fixed(1),
                    contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(recipesImages.size) {
                        JustForYouImageItem(justForYou = recipesImages[it])
                        Spacer(modifier = Modifier.width(15.dp))

                    }
                }
            }
        }
    }

}

@Composable
fun JustForYouImageItem(justForYou: JustForYou) {

    Box(
        modifier = Modifier
            .fillMaxHeight()
        // .height(50.dp)
    ) {
        Card(
            Modifier.size(200.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        ) {
            Image(
                painter = painterResource(id = justForYou.image),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            )
                        )
                    )
            )

            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = justForYou.name,
                    style = MaterialTheme.typography.h4,
                    textAlign = TextAlign.Center

                )
            }
        }


    }

}


@Composable
fun BottomMenu(

    item: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    // activeHighLightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    //  inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0

) {

    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
        //.fillMaxHeight()
        //   .background(DeepBlue)
        //.padding(15.dp)
    ) {
        item.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                //      activeHighLightColor = activeHighLightColor,
                //      activeTextColor = activeTextColor,
                //      inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}


@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighLightColor: Color = Color.Magenta,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighLightColor else Color.Transparent)
        ) {
            Icon(
                painter = painterResource(id = item.image),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(27.dp)
            )
        }
        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor
        )
    }

}


