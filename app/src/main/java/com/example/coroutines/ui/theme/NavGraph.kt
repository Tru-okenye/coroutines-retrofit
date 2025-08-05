package com.example.coroutines.ui.theme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.coroutines.model.Post
import com.example.coroutines.viewmodel.PostViewModel
import com.google.gson.Gson

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val viewModel: PostViewModel = viewModel()

    NavHost(navController, startDestination = "list") {
        composable("list") {
            PostListScreen(
                viewModel = viewModel,
                onPostClick = { post ->
                    val json = Gson().toJson(post).encode()
                    navController.navigate("detail/$json")
                }
            )
        }

        composable(
            "detail/{postJson}",
            arguments = listOf(navArgument("postJson") { type = NavType.StringType })
        ) { backStackEntry ->
            val encoded = backStackEntry.arguments?.getString("postJson")

            // Do decoding + parsing outside of the Composable call
            val post = encoded
                ?.let { safeEncoded -> safeEncoded.decode() }
                ?.let { decodedJson -> Gson().fromJson(decodedJson, Post::class.java) }

            if (post != null) {
                PostDetailScreen(post = post) {
                    navController.popBackStack()
                }
            } else {
                // Optional: Show an error UI instead of crashing
                Text("Invalid post data")
            }
        }
    }
}
