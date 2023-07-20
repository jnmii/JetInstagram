package com.vipulasri.jetinstagram.ui.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.model.currentUser


@ExperimentalFoundationApi
@Preview
@Composable
fun ProfilePage() {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()

            .background(Color.Black)
    ) {
        TopBar(
            name = currentUser.name,
            modifier = Modifier.padding(10.dp),
            icon = Icons.Default.KeyboardArrowDown
        )
        Spacer(modifier = Modifier.height(4.dp))
        ProfilePicSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))
        HighlightSection(
            highlights = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_outlined_favorite),
                    text = "Fun"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_filled_home),
                    text = "Work"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_filled_reels),
                    text = "Life"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_launcher_background),
                    text = "Android"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_launcher_foreground),
                    text = "Scroll"
                ),


                ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            imageWithTexts = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_outlined_favorite),
                    text = "Posts"
                ),ImageWithText(
                    image = painterResource(id = R.drawable.ic_outlined_favorite),
                    text = "Posts"
                ),ImageWithText(
                    image = painterResource(id = R.drawable.ic_outlined_favorite),
                    text = "Posts"
                ),
            )
        ){
            selectedTabIndex = it
        }
        when(selectedTabIndex){
            0-> PostSection(
                posts = listOf(
                    painterResource(id =R.drawable.ic_outlined_comment),
                    painterResource(id =R.drawable.ic_outlined_comment),
                    painterResource(id =R.drawable.ic_outlined_comment),
                    painterResource(id =R.drawable.ic_outlined_comment),
                    painterResource(id =R.drawable.ic_outlined_comment),
                    painterResource(id =R.drawable.ic_outlined_comment),
                    painterResource(id =R.drawable.ic_outlined_comment),
                    painterResource(id = R.drawable.ic_outlined_comment),
                ),
            modifier = Modifier.fillMaxWidth()
            )
        }

    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null
) {
    Row(

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween, // Change to SpaceBetween to make icons closer together
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp) // Add padding to the whole row
    ) {
        Text(
            text = name,
            overflow = TextOverflow.Clip,
            fontWeight = FontWeight.Bold,
            style = TextStyle(Color.White),
            fontSize = 20.sp,
            modifier = Modifier.weight(1f), // Use weight to push the text to the left side

        )

        Row(modifier = Modifier.padding(5.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.screenshot_2023_07_19_112724),
                contentDescription = "White",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(25.dp)) // Add space of 8.dp between the icons
            Icon(
                painterResource(id = R.drawable.ic_outlined_add),
                contentDescription = "Black",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(25.dp)) // Add space of 8.dp between the icons
            Icon(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "Black",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}


@Composable
fun ProfilePicSection(
    modifier: Modifier = Modifier
) {

    Row() {


    }
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = rememberImagePainter(currentUser.image), modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
        ProfileDescription(
            displayName = currentUser.name,
            description = "A little someething about me",
            url = "jkdsfsbfsjkbjhgb.com",
            followedBy = listOf("miakhalifa, JayZ,Kendrick.Lamar"),
            otherCount = 22
        )
    }

}

@Composable
fun RoundImage(
    image: Painter, modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp, color = Color.LightGray, shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )


}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {


        ProfileStat(numberText = "25", text = "Posts")
        ProfileStat(numberText = "1M", text = "Followers")
        ProfileStat(numberText = "71", text = "Following")

    }
}

@Composable
fun ProfileStat(
    numberText: String, text: String, modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            style = TextStyle(Color.White)

        )
        Spacer(Modifier.height(4.dp))
        Text(text = text, style = TextStyle(Color.White))
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(

        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            style = TextStyle(Color.White),
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight

        )
        Text(
            style = TextStyle(Color.White),
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            style = TextStyle(Color.White),
            text = url,
            color = Color(0xFF3d3d91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if (followedBy.isNotEmpty()) {
            Text(
                style = TextStyle(Color.White),
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    pushStyle(boldStyle)
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(",")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier

) {
    val minWidth = 95.dp
    val height = 30.dp

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,


        modifier = modifier

    ) {
        ActionButton(
            text = "Edit profile",

            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
                .weight(.5f)

        )
        Spacer(modifier = Modifier.width(1.dp))
        ActionButton(
            text = "Share profile",

            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
                .weight(.5f)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null,

    ) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 2.dp,
                color = Color.Black,

                shape = RoundedCornerShape(9.dp)
            )
            .background(color = Color.DarkGray, shape = RoundedCornerShape(9.dp))
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(
                style = TextStyle(Color.White),
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<ImageWithText>
) {
    LazyRow(modifier = modifier) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 15.dp)
            ) {
                RoundImage(
                    image = highlights[it].image,
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = highlights[it].text,
                    style = TextStyle(Color.White),
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }


        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithTexts.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.White,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.White else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }

        }
    }
}


@ExperimentalFoundationApi
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01F)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )

            )
        }

    }
}


