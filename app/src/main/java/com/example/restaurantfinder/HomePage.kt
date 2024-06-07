package com.example.restaurantfinder

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController


data class NavItemState (
    val title :String,
    val selectedIcon : ImageVector,
    val unselected : ImageVector,
    val hasBadge: Boolean,
    val badgeNumber: Int
){


}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavHostController , modifier: Modifier = Modifier) {

    var items = listOf(

        NavItemState(

            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselected = Icons.Outlined.Home,
            hasBadge = false,
            badgeNumber = 0
        ),
        NavItemState(

            title = "Map",
            selectedIcon = Icons.Filled.Place,
            unselected = Icons.Outlined.Place,
            hasBadge = false,
            badgeNumber = 0

        ),
        NavItemState(

            title = "Favorites",
            selectedIcon = Icons.Filled.Favorite,
            unselected = Icons.Outlined.Favorite,
            hasBadge = false,
            badgeNumber = 0

        ),
        NavItemState(

            title = "Profile",
            selectedIcon = Icons.Filled.AccountCircle,
            unselected = Icons.Outlined.AccountCircle,
            hasBadge = false,
            badgeNumber = 0

        )

    )

    var bottomNavState by rememberSaveable {
        mutableStateOf(0)
    }


    Scaffold (

        bottomBar = {

            NavigationBar {
                items.forEachIndexed{index , item ->
                    NavigationBarItem(
                        selected = bottomNavState == index ,
                        onClick = { bottomNavState = index },
                        icon = { 
                            
                            BadgedBox(badge = {

                                if (item.hasBadge) Badge {}
                                if (item.badgeNumber != 0 ) Badge {
                                    Text(text = item.badgeNumber.toString())
                                }
                                
                            }) {
                                Icon(imageVector = if (bottomNavState == index) item.selectedIcon
                                    else item.unselected
                                    , contentDescription = item.title)

                            }
                        },
                        label = {
                            Text(text = item.title)
                        }
                        )

                }
            }
        }
    ){



    }

}