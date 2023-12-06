package com.cencen.bloommate

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cencen.bloommate.ui.navigation.ItemNavigation
import com.cencen.bloommate.ui.navigation.Screen
import com.cencen.bloommate.ui.screen.dictionary.DictionaryScreen
import com.google.accompanist.pager.ExperimentalPagerApi


@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun BloomMateApp(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
) {
    val navBackStack by navHostController.currentBackStackEntryAsState()
    val currentRoutes = navBackStack?.destination?.route

    Scaffold (
        bottomBar = {
            if (currentRoutes != Screen.DetailDictionary.routes) {
                BottomBar(navHostController)
            }
        },
        modifier = modifier
    ) {innerPadding ->
        NavHost(navController = navHostController,
            startDestination = Screen.Dictionary.routes,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Dictionary.routes) {
                DictionaryScreen()
                //tambahkan navToDetail
            }
            //tambah composable lainya
            //besok lagi ya gue capek
        }
    }
}

@Composable
fun BottomBar(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        val navBackStack by navHostController.currentBackStackEntryAsState()
        val currentRoutes = navBackStack?.destination?.route
        val navItems = listOf(
            ItemNavigation(
                title = stringResource(id = R.string.home),
                icons = R.drawable.ic_home,
                screen = Screen.Home
            ),
            ItemNavigation(
                title = stringResource(id = R.string.cart),
                icons = R.drawable.ic_cart,
                screen = Screen.Cart
            ),
            ItemNavigation(
                title = stringResource(id = R.string.dictionary),
                icons = R.drawable.ic_book,
                screen = Screen.Dictionary
            ),
            ItemNavigation(
                title = stringResource(id = R.string.profile),
                icons = R.drawable.ic_profile,
                screen = Screen.Profile
            ),
        )
        navItems.map { items ->
            NavigationBarItem(
                selected = currentRoutes == items.screen.routes,
                onClick = {
                          navHostController.navigate(items.screen.routes){
                              popUpTo(navHostController.graph.findStartDestination().id) {
                                  saveState = true
                              }
                              restoreState = true
                              launchSingleTop = true
                          }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = items.icons),
                        contentDescription = items.title )
                })
        }
    }
}
