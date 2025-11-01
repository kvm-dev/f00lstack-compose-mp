package ru.kvmsoft.base.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.kvmsoft.base.ui.background.baseBackground
import ru.kvmsoft.base.ui.icons.interviewIcon
import ru.kvmsoft.base.ui.icons.mainIcon
import ru.kvmsoft.base.ui.icons.newsIcon
import ru.kvmsoft.base.ui.icons.testsIcon
import ru.kvmsoft.base.ui.theme.SelectedNavigationColor
import ru.kvmsoft.base.ui.theme.UnselectedNavigationColor
import ru.kvmsoft.base.ui.utils.NoRippleConfiguration
import ru.kvmsoft.features.authorization.imp.presentation.ui.AuthorizationScreen
import ru.kvmsoft.features.interview.imp.presentation.ui.InterviewListScreen
import ru.kvmsoft.features.main.imp.presentation.ui.MainScreen
import ru.kvmsoft.features.news.imp.presentation.ui.NewsListScreen
import ru.kvmsoft.features.profile.imp.presentation.ui.ProfileScreen
import ru.kvmsoft.features.splash.imp.presentation.ui.SplashScreen
import ru.kvmsoft.features.tests.imp.presentation.ui.TestsListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationApp() {
    var isShowNavBar by remember { mutableStateOf(false) }
    val navController = rememberNavController() // Инициализация контроллера навигации
    val allNavigationItems = getDestinationsList()
    val navigationBarItemColors = NavigationBarItemDefaults.colors(
        indicatorColor = Color.Transparent, // Color of the selected item's indicator
        selectedIconColor = SelectedNavigationColor, // Color of the icon when selected
        unselectedIconColor = UnselectedNavigationColor, // Color of the icon when unselected
        selectedTextColor = SelectedNavigationColor, // Color of the text when selected
        unselectedTextColor = UnselectedNavigationColor // Color of the text when unselected
    )
    val background = rememberVectorPainter(image = baseBackground)
    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = {
            if(isShowNavBar){
               HorizontalDivider(Modifier.padding(horizontal = 20.dp), 1.dp, UnselectedNavigationColor)
                BottomAppBar(
                    containerColor = Color.Transparent,
                    modifier = Modifier
                        .padding(top = 10.dp)
                ){
                    // Нижняя панель приложения
                    NavigationBar(
                        containerColor = Color.Transparent
                    )  { // Компонент для нижней навигации
                        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route // Текущий маршрут
                        allNavigationItems.forEach { item ->
                            CompositionLocalProvider(LocalRippleConfiguration provides NoRippleConfiguration) {
                                when(item.route){
                                    "main"->{
                                        NavigationBarItem(
                                        colors = navigationBarItemColors,
                                        icon = {
                                            Icon(
                                                imageVector = mainIcon, // Reference your ImageVector from the .kt file
                                                contentDescription = null,
                                                modifier = Modifier.size(32.dp),
                                            )
                                        },
                                        label = { Text(item.label) },
                                        selected = currentRoute == item.route,
                                        onClick = {
                                            navController.navigate(item.route) {
                                                // Опции навигации, например, чтобы избежать повторных входов в один и тот же экран
                                                popUpTo(navController.graph.findStartDestination().id) {
                                                    saveState = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    )
                                    }
                                    "interviewList"->{
                                        NavigationBarItem(
                                            colors = navigationBarItemColors,
                                            icon = {
                                                Icon(
                                                    imageVector = interviewIcon, // Reference your ImageVector from the .kt file
                                                    contentDescription = null,
                                                    modifier = Modifier.size(32.dp),
                                                )
                                            },
                                            label = { Text(item.label) },
                                            selected = currentRoute == item.route,
                                            onClick = {
                                                navController.navigate(item.route) {
                                                    // Опции навигации, например, чтобы избежать повторных входов в один и тот же экран
                                                    popUpTo(navController.graph.findStartDestination().id) {
                                                        saveState = true
                                                    }
                                                    launchSingleTop = true
                                                    restoreState = true
                                                }
                                            }
                                        )
                                    }
                                    "testsList"->{
                                        NavigationBarItem(
                                            colors = navigationBarItemColors,
                                            icon = {
                                                Icon(
                                                    imageVector = testsIcon, // Reference your ImageVector from the .kt file
                                                    contentDescription = item.label,
                                                    modifier = Modifier.size(32.dp),
                                                )
                                            },
                                            label = { Text(item.label) },
                                            selected = currentRoute == item.route,
                                            onClick = {
                                                navController.navigate(item.route) {
                                                    // Опции навигации, например, чтобы избежать повторных входов в один и тот же экран
                                                    popUpTo(navController.graph.findStartDestination().id) {
                                                        saveState = true
                                                    }
                                                    launchSingleTop = true
                                                    restoreState = true
                                                }
                                            }
                                        )
                                    }
                                    "newsList"->{
                                        NavigationBarItem(
                                            colors = navigationBarItemColors,
                                            icon = {
                                                Icon(
                                                    imageVector = newsIcon, // Reference your ImageVector from the .kt file
                                                    contentDescription = null,
                                                    modifier = Modifier.size(32.dp),
                                                )
                                            },
                                            label = { Text(item.label) },
                                            selected = currentRoute == item.route,
                                            onClick = {
                                                navController.navigate(item.route) {
                                                    // Опции навигации, например, чтобы избежать повторных входов в один и тот же экран
                                                    popUpTo(navController.graph.findStartDestination().id) {
                                                        saveState = true
                                                    }
                                                    launchSingleTop = true
                                                    restoreState = true
                                                }
                                            }
                                        )
                                    }
                                    else->{}
                                }
//                                if(item.icon!=null){
//                                    NavigationBarItem(
//                                        colors = navigationBarItemColors,
//                                        icon = {
//                                            item.icon.let {
//                                                Icon(
//                                                    imageVector = it, // Reference your ImageVector from the .kt file
//                                                    contentDescription = it.name,
//                                                    modifier = Modifier.size(32.dp),
//                                                )
//                                            }
//                                        },
//                                        label = { Text(item.label) },
//                                        selected = currentRoute == item.route,
//                                        onClick = {
//                                            navController.navigate(item.route) {
//                                                // Опции навигации, например, чтобы избежать повторных входов в один и тот же экран
//                                                popUpTo(navController.graph.findStartDestination().id) {
//                                                    saveState = true
//                                                }
//                                                launchSingleTop = true
//                                                restoreState = true
//                                            }
//                                        }
//                                    )
//                                }
                            }
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        NavHost(modifier = Modifier.fillMaxSize()
            .paint(painter = background,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                sizeToIntrinsics = true),
            navController = navController,
            startDestination = AppDestinations.Splash().route // Splash экран
        ) {
            // Определяем маршруты и их Composable-функции
            composable(AppDestinations.Main().route) {
                MainScreen()
                isShowNavBar = true
            }
            composable(AppDestinations.InterviewList().route) {
                InterviewListScreen()
                isShowNavBar = true
            }
            composable(AppDestinations.TestsList().route) {
                TestsListScreen()
                isShowNavBar = true
            }
            composable(AppDestinations.NewsList().route) {
                NewsListScreen()
                isShowNavBar = true
            }
            composable(AppDestinations.Authorization().route) {
                AuthorizationScreen()
                isShowNavBar = false
            }
            composable(AppDestinations.Professions().route) {
                ProfileScreen()
                isShowNavBar = false
            }
            composable(AppDestinations.Splash().route) {
                SplashScreen(onNavigateToHome = {
                    navController.navigate(route = AppDestinations.Main().route)
                    {popUpTo(AppDestinations.Splash().route){
                        inclusive = true
                    }}
                    isShowNavBar = true},
                    onNavigationAuthorization = {
                        navController.navigate(route = AppDestinations.Authorization().route)
                        { popUpTo(AppDestinations.Splash().route){
                            inclusive = true
                        }}
                        isShowNavBar = false})
            }
        }
    }
}