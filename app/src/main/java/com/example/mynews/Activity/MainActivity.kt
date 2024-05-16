package com.example.mynews.Activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mynews.Activity.Pages.FavouritePage
import com.example.mynews.Activity.Pages.HomePage
import com.example.mynews.Model.BottomNavigationItem
import com.example.mynews.ViewModel.NewsViewModel
import com.example.mynews.ui.theme.MynewsTheme

class MainActivity : ComponentActivity() {
    val viewModel:NewsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MynewsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowBottomNavigation()
                }
            }
        }
    }


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    @Preview(showBackground = true)
    fun ShowBottomNavigation(){
        val item = listOf(
            BottomNavigationItem(
                title = "Home",
                selectedItem = Icons.Filled.Home,
                unselectedItem = Icons.Outlined.Home
            ),
            BottomNavigationItem(
                title = "Favourite",
                selectedItem = Icons.Filled.Favorite,
                unselectedItem = Icons.Outlined.Favorite
            ),
        )
        var indexItem by remember {
            mutableIntStateOf(0)
        }
        val navController = rememberNavController()
        Scaffold(
            bottomBar = {
                NavigationBar {
                    item.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = indexItem==index,
                            label = {
                                    Text(text = item.title)
                            },
                            onClick = {
                                indexItem=index
                                navController.navigate(item.title)
                            },
                            icon = {
                                Icon(imageVector = if(indexItem==index){
                                    item.selectedItem
                                }else item.unselectedItem,
                                    contentDescription = item.title)

                            })
                    }
                }
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = "Home"
            ) {
                composable("Home"){
                    HomePage(viewModel = viewModel)
                }
                composable("Favourite"){
                    FavouritePage()
                }
            }
        }
    }
}

