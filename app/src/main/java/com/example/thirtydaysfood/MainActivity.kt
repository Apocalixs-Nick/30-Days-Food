package com.example.thirtydaysfood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirtydaysfood.model.Food
import com.example.thirtydaysfood.model.FoodDataSource.foodList
import com.example.thirtydaysfood.ui.theme.ThirtyDaysFoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysFoodTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FoodApp()
                }
            }
        }
    }
}

@Composable
fun FoodApp() {
    Scaffold(
        topBar = {
            FoodAppTopAppBar()
        }
    ) {
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
            items(foodList) {
                FoodAppItem(food = it)
            }
        }
    }
}

@Composable
fun FoodAppTopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(56.dp)
            .background(color = MaterialTheme.colors.primary)
            .wrapContentWidth(Alignment.CenterHorizontally)
            .wrapContentHeight(Alignment.CenterVertically)
        //contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h1
        )
    }
}

@Composable
fun FoodAppItem(food: Food, modifier: Modifier = Modifier) {

    Card(
        elevation = 40.dp,
        modifier = modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                FoodAppInformation(food.dayFood, food.titleFood, food.imageFood, food.descriptionFood)
                Spacer(Modifier.weight(1f))
                //SuperheroesIcon(hero.imageRes)
                //Spacer(Modifier.weight(1f))
                //DogItemButton(
                //expanded = expanded,
                //onClick = { expanded = !expanded },
                //)
            }
        }
    }
}


@Composable
fun FoodAppInformation(
    @StringRes dayFood: Int,
    titleFood: Int,
    imageFood: Int,
    descriptionFood: Int,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 8.dp)) {
        Text(
            text = stringResource(dayFood),
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Medium
            //modifier = modifier.padding(top = 16.dp),
        )
        Text(
            text = stringResource(titleFood),
            style = MaterialTheme.typography.h2
        )
        Image(
            painter = painterResource(imageFood),
            contentDescription = null,
            modifier = Modifier
                .clickable {
                    expanded = !expanded
                }
                .padding(top = 8.dp, bottom = 8.dp)
        )
        if (expanded) FoodAppItemDescription(descriptionFood)
    }
}

@Composable
private fun FoodAppItemDescription(descriptionFood: Int) {
    Text(
        text = stringResource(descriptionFood),
        style = MaterialTheme.typography.h2
    )
}

@Preview(showSystemUi = true)
@Composable
fun FoodAppPreview() {
    ThirtyDaysFoodTheme(darkTheme = false){
        FoodApp()
    }
}

@Preview(showSystemUi = true)
@Composable
fun FoodAppDarkThemePreview() {
    ThirtyDaysFoodTheme(darkTheme = true) {
        FoodApp()
    }
}