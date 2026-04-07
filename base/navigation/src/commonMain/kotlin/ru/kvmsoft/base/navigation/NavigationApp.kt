package ru.kvmsoft.base.navigation

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import ru.kvmsoft.base.ui.background.baseBackground
import ru.kvmsoft.base.ui.icons.interviewIcon
import ru.kvmsoft.base.ui.icons.mainIcon
import ru.kvmsoft.base.ui.icons.newsIcon
import ru.kvmsoft.base.ui.icons.testsIcon
import ru.kvmsoft.base.ui.theme.MainOrangeLight
import ru.kvmsoft.base.ui.theme.SelectedNavigationColor
import ru.kvmsoft.base.ui.theme.Turquoise
import ru.kvmsoft.base.ui.theme.UnselectedNavigationColor
import ru.kvmsoft.base.ui.utils.NoRippleConfiguration
import ru.kvmsoft.base.utils.navigationScreens.AppDestinations
import ru.kvmsoft.base.utils.navigationScreens.getDestinationsList
import ru.kvmsoft.base.utils.navigationScreens.getLabel
import ru.kvmsoft.features.authorization.imp.presentation.ui.AuthorizationScreen
import ru.kvmsoft.features.events.imp.presentation.ui.EventsInnerScreen
import ru.kvmsoft.features.events.imp.presentation.ui.EventsListScreen
import ru.kvmsoft.features.interview.imp.presentation.ui.InterviewListScreen
import ru.kvmsoft.features.main.imp.presentation.ui.MainScreen
import ru.kvmsoft.features.news.imp.presentation.ui.NewsInnerScreen
import ru.kvmsoft.features.news.imp.presentation.ui.NewsListScreen
import ru.kvmsoft.features.profile.imp.presentation.ui.ProfileScreen
import ru.kvmsoft.features.splash.imp.presentation.ui.SplashScreen
import ru.kvmsoft.features.tests.imp.presentation.ui.TestsListScreen

@Suppress("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationApp(langIsRus: Boolean) {
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
    var withSplashBackground by remember { mutableStateOf( true) }
    val background = rememberVectorPainter(image = baseBackground)
    var modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    MainOrangeLight,
                    Turquoise
                )
            )
        )
    if(!withSplashBackground){
        modifier = Modifier
            .fillMaxSize()
            .paint(painter = background,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                sizeToIntrinsics = true)
    }

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
                        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.id // Текущий маршрут
                        allNavigationItems.forEach { item ->
                            CompositionLocalProvider(LocalRippleConfiguration provides NoRippleConfiguration) {
                                when(item){
                                    is AppDestinations.Main -> {
                                        NavigationBarItem(
                                        colors = navigationBarItemColors,
                                        icon = {
                                            Icon(
                                                imageVector = mainIcon, // Reference your ImageVector from the .kt file
                                                contentDescription = null,
                                                modifier = Modifier.size(32.dp),
                                            )
                                        },
                                        label = { Text(getLabel(destinations = item, isLangRus = langIsRus)?:"") },
                                        selected = currentRoute == item.hashCode(),
                                        onClick = {
                                            navController.navigate(item) {
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
                                    is AppDestinations.InterviewList -> {
                                        NavigationBarItem(
                                            colors = navigationBarItemColors,
                                            icon = {
                                                Icon(
                                                    imageVector = interviewIcon, // Reference your ImageVector from the .kt file
                                                    contentDescription = null,
                                                    modifier = Modifier.size(32.dp),
                                                )
                                            },
                                            label = { Text(getLabel(destinations = item, isLangRus = langIsRus)?:"") },
                                            selected = currentRoute == item.hashCode(),
                                            onClick = {
                                                navController.navigate(item) {
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
                                    is AppDestinations.TestsList -> {
                                        NavigationBarItem(
                                            colors = navigationBarItemColors,
                                            icon = {
                                                Icon(
                                                    imageVector = testsIcon, // Reference your ImageVector from the .kt file
                                                    contentDescription = getLabel(destinations = item, isLangRus = langIsRus),
                                                    modifier = Modifier.size(32.dp),
                                                )
                                            },
                                            label = { Text(getLabel(destinations = item, isLangRus = langIsRus)?:"") },
                                            selected = currentRoute == item.hashCode(),
                                            onClick = {
                                                navController.navigate(item) {
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
                                    is AppDestinations.NewsList -> {
                                        NavigationBarItem(
                                            colors = navigationBarItemColors,
                                            icon = {
                                                Icon(
                                                    imageVector = newsIcon, // Reference your ImageVector from the .kt file
                                                    contentDescription = null,
                                                    modifier = Modifier.size(32.dp),
                                                )
                                            },
                                            label = { Text(getLabel(destinations = item, isLangRus = langIsRus)?:"") },
                                            selected = currentRoute == item.hashCode(),
                                            onClick = {
                                                navController.navigate(item) {
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
                            }
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(modifier = modifier,
            navController = navController,
            startDestination = AppDestinations.Splash
        ){
            // Определяем маршруты и их Composable-функции
            composable<AppDestinations.Main> {
                MainScreen(
                    onNavigationAuthorization = {
                        navController.navigate(route = AppDestinations.Authorization)
                        { popUpTo(AppDestinations.Splash){
                            inclusive = true
                        }}
                        isShowNavBar = false
                                                },
                    navController = navController,
                    eventDestination = AppDestinations.EventsInner(),
                    onclickEvents =  {
                        isShowNavBar = false
                        navController.navigate(route = AppDestinations.EventsList)
                    }
                )
                isShowNavBar = true
                withSplashBackground = false
            }
            composable<AppDestinations.InterviewList> {
                InterviewListScreen(
                    onNavigationAuthorization = {
                        navController.navigate(route = AppDestinations.Authorization)
                        { popUpTo(AppDestinations.Splash){
                            inclusive = true
                        }}
                        isShowNavBar = false
                    }
                )
                isShowNavBar = true
            }
            composable<AppDestinations.TestsList> {
                TestsListScreen(
                    onNavigationAuthorization = {
                    navController.navigate(route = AppDestinations.Authorization)
                    { popUpTo(AppDestinations.Splash){
                        inclusive = true
                    }}
                    isShowNavBar = false
                    })
                isShowNavBar = true
            }
            composable<AppDestinations.NewsList> {
                NewsListScreen(
                    navController = navController,
                    newsDestination = AppDestinations.NewsInner(),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding))
                isShowNavBar = true
            }
            composable<AppDestinations.NewsInner>
            { backStackEntry->
                val newsId = backStackEntry.toRoute<AppDestinations.NewsInner>().newsId
                NewsInnerScreen(
                    newsId = newsId,
                    onClickBack = {
                        isShowNavBar = true
                        navController.popBackStack()
                    }
                )
                isShowNavBar = false
            }
            composable<AppDestinations.Authorization> {
                AuthorizationScreen(onAuthorized = {
                    navController.navigate(route = AppDestinations.Main)
                    { popUpTo(AppDestinations.Authorization){
                        inclusive = true
                    }}
                    isShowNavBar = true
                })
                isShowNavBar = false
                withSplashBackground = false
            }
            composable<AppDestinations.Professions> {
                ProfileScreen(
                    onNavigationAuthorization = {
                    navController.navigate(route = AppDestinations.Authorization)
                    { popUpTo(AppDestinations.Splash){
                        inclusive = true
                    }}
                    isShowNavBar = false
                    })
                isShowNavBar = false
            }
            composable<AppDestinations.Splash> {
                SplashScreen(onNavigateToHome = {
                    navController.navigate(route = AppDestinations.Main)
                    {popUpTo(AppDestinations.Splash){
                        inclusive = true
                    }}
                    isShowNavBar = true
                                                },
                    onNavigationAuthorization = {
                        navController.navigate(route = AppDestinations.Authorization)
                        { popUpTo(AppDestinations.Splash){
                            inclusive = true
                        }}
                        isShowNavBar = false
                    })
            }
            composable<AppDestinations.EventsList> {
                EventsListScreen(
                    navController = navController,
                    eventDestination = AppDestinations.EventsInner(),
                    onClickBack = {
                        isShowNavBar = true
                        navController.popBackStack()
                    })
                isShowNavBar = false
            }
            composable<AppDestinations.EventsInner>
            { backStackEntry->
                val eventId = backStackEntry.toRoute<AppDestinations.EventsInner>().eventId
                EventsInnerScreen(onClickBack = { navController.popBackStack() },
                    eventId = eventId)
                isShowNavBar = false
            }
        }
    }
}