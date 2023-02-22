package com.example.jetpackcomposeinstagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposeinstagram.login.ui.LoginScreen
import com.example.jetpackcomposeinstagram.login.ui.LoginViewModel
import com.example.jetpackcomposeinstagram.model.Routes
import com.example.jetpackcomposeinstagram.ui.theme.JetpackComposeInstagramTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeInstagramTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    SimpleGridView()


                    LoginScreen(LoginViewModel())


                    //* SCAFFOLD
//                    val navigationController = rememberNavController()
//                    NavHost(
//                        navController = navigationController,
//                        startDestination = Routes.Pantalla1.routes
//                    ) {
//                        composable(Routes.Pantalla1.routes) { Screen1(navigationController) }
//                        composable(Routes.Pantalla2.routes) { Screen2(navigationController) }
//                        composable(Routes.Pantalla3.routes) { Screen3(navigationController) }
//                        composable(
//                            Routes.Pantalla4.routes,
//                            arguments = listOf(navArgument("age") { type = NavType.IntType })
//                        ) {
//                            Screen4(
//                                navigationController,
//                                it.arguments?.getInt("age") ?: 0
//                            )
//                        }
//                        composable(
//                            Routes.Pantalla5.routes,
//                            arguments = listOf(navArgument("name") { defaultValue = "Perco" })
//                        ) {
//                            Screen5(
//                                navigationController,
//                                it.arguments?.getString("name")
//                            )
//                        }
//                    }

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
    JetpackComposeInstagramTheme {
        Greeting("Android")
    }
}