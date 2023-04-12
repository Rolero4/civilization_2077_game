package com.mobilne.civ2077.ui.board.views.tree

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mobilne.civ2077.R

@Composable
fun Tree(viewModel: TreeViewModel) {
    // Todo czytanie z bazy zamiast funkcji, które czytają stan początkowy
    viewModel.initState()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier
                    .weight(2.5f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 0.dp),
                        text = "Economy",
                        color = Color.Blue,
                        style = MaterialTheme.typography.h4,
                    )
                    Spacer(modifier = Modifier.width(width = 10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.economy),
                        contentDescription = "Economy",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    EconomyItem(1, viewModel)
                    EconomyItem(2, viewModel)
                    EconomyItem(3, viewModel)
                    EconomyItem(4, viewModel)
                }
            }
            Column(
                modifier = Modifier
                    .weight(2.5f)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 0.dp),
                        text = "Army",
                        color = Color.Red,
                        style = MaterialTheme.typography.h4,
                    )
                    Spacer(modifier = Modifier.width(width = 10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.army),
                        contentDescription = "Army",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(40.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ArmyItem(1, viewModel)
                    ArmyItem(2, viewModel)
                    ArmyItem(3, viewModel)
                    ArmyItem(4, viewModel)
                }
            }
            Row(
                modifier = Modifier
                    .weight(1f),
                verticalAlignment = Alignment.Bottom
            ) {
                InfoBar(viewModel)
            }
        }
    }
}

@Composable
fun EconomyItem(
    id: Int = 1,
    viewModel: TreeViewModel
) {
    Button(
        modifier = Modifier
            .height(80.dp)
            .width(80.dp),
        shape = RectangleShape,
        contentPadding = PaddingValues(16.dp),
        enabled = viewModel.economyPerksButtonsState[id - 1],
        onClick = { viewModel.changeForEconomyPerk() },
    ) {
        Text(
            text = "lvl $id",
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center,
            color = Color(255, 255, 255)
        )
    }
}

@Composable
fun ArmyItem(
    id: Int = 1,
    viewModel: TreeViewModel
) {
    Button(
        modifier = Modifier
            .height(80.dp)
            .width(80.dp),
        shape = RectangleShape,
        contentPadding = PaddingValues(16.dp),
        enabled = viewModel.armyPerksButtonsState[id - 1],
        onClick = { viewModel.changeForArmyPerk() },
    ) {
        Text(
            text = "lvl $id",
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center,
            color = Color(255, 255, 255)
        )
    }
}


@Composable
fun InfoBar(
    viewModel: TreeViewModel
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(7f),
            text = viewModel.currentPerk,
            textAlign = TextAlign.Center,
        )
        Button(
            modifier = Modifier
                .height(50.dp)
                .width(150.dp)
                .weight(3f),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff507d00)),
            shape = RectangleShape,
            contentPadding = PaddingValues(16.dp),
            enabled = viewModel.buyButtonState,
            onClick = {
                viewModel.buy()
            },
        ) {
            Text(
                text = "Buy for " + viewModel.goldToPay,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                color = Color(255, 255, 255)
            )
        }
    }
}

//@Preview
//@Composable
//fun PreviewTree() {
//    Tree(TreeViewModel(player = Player(), id=0, gameRepository = hiltViewModel()))
//}