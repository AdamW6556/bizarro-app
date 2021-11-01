package com.example.bizarro.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.bizarro.ui.NavGraph
import com.example.bizarro.ui.Screen
import com.example.bizarro.ui.components.BottomNavItem
import com.example.bizarro.ui.components.BottomNavigationBar
import com.example.bizarro.ui.theme.BizarroTheme
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception
import javax.inject.Inject
import javax.net.ssl.SSLContext

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appState: AppState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BizarroTheme {
                val navController = rememberNavController()

                Scaffold(bottomBar = {
                    if (appState.bottomMenuVisible.value) {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    Screen.Compare.name,
                                    Screen.Compare.route,
                                    icon = Icons.Default.Check,
                                ),
                                BottomNavItem(
                                    Screen.UserRecordList.name,
                                    Screen.UserRecordList.route,
                                    icon = Icons.Default.List,
                                ),
                                BottomNavItem(
                                    Screen.Home.name,
                                    Screen.Home.route,
                                    icon = Icons.Default.Home,
                                ),
                                BottomNavItem(
                                    Screen.Search.name,
                                    Screen.Search.route,
                                    icon = Icons.Default.Search,
                                ),
                                BottomNavItem(
                                    Screen.UserProfile.name,
                                    Screen.UserProfile.route,
                                    icon = Icons.Default.Person,
                                ),
                            ),
                            navController = navController,
                        )
                    }
                }) {
                    NavGraph(navController = navController)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BizarroTheme {
        Greeting("Android")
    }
}
