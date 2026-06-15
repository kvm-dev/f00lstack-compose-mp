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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
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
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.koin.compose.koinInject
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
import ru.kvmsoft.base.utils.navigationScreens.getLabel
import ru.kvmsoft.features.authorization.imp.presentation.ui.AuthorizationScreen
import ru.kvmsoft.features.events.imp.presentation.ui.EventsInnerScreen
import ru.kvmsoft.features.events.imp.presentation.ui.EventsListScreen
import ru.kvmsoft.features.interview.imp.presentation.ui.InterviewListScreen
import ru.kvmsoft.features.interview.imp.presentation.viewmodel.InterviewListScreenViewModel
import ru.kvmsoft.features.main.imp.presentation.ui.MainScreen
import ru.kvmsoft.features.main.imp.presentation.viewmodel.MainScreenViewModel
import ru.kvmsoft.features.news.imp.presentation.ui.NewsInnerScreen
import ru.kvmsoft.features.news.imp.presentation.ui.NewsListScreen
import ru.kvmsoft.features.news.imp.presentation.viewmodel.NewsListScreenViewModel
import ru.kvmsoft.features.profile.imp.presentation.ui.ProfileScreen
import ru.kvmsoft.features.splash.imp.presentation.ui.SplashScreen
import ru.kvmsoft.features.study.imp.presentation.ui.StudyListScreen
import ru.kvmsoft.features.tests.imp.presentation.ui.TestsListScreen
import ru.kvmsoft.features.tests.imp.presentation.viewmodel.TestsListScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationApp(langIsRus: Boolean) {
    val navController = rememberNavController()
    val bottomBarItems = remember {
        listOf(
            AppDestinations.Main,
            AppDestinations.InterviewList,
            AppDestinations.TestsList,
            AppDestinations.NewsList
        )
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val isShowNavBar by remember(currentDestination) {
        derivedStateOf {
            currentDestination?.let { destination ->
                destination.hasRoute<AppDestinations.Main>() ||
                        destination.hasRoute<AppDestinations.InterviewList>() ||
                        destination.hasRoute<AppDestinations.TestsList>() ||
                        destination.hasRoute<AppDestinations.NewsList>()
            } ?: false
        }
    }

    var withSplashBackground by remember { mutableStateOf(true) }
    LaunchedEffect(currentDestination) {
        currentDestination?.let { dest ->
            if (dest.hasRoute<AppDestinations.Main>() || dest.hasRoute<AppDestinations.Authorization>()) {
                withSplashBackground = false
            }
        }
    }

    val navigationBarItemColors = NavigationBarItemDefaults.colors(
        indicatorColor = Color.Transparent,
        selectedIconColor = SelectedNavigationColor,
        unselectedIconColor = UnselectedNavigationColor,
        selectedTextColor = SelectedNavigationColor,
        unselectedTextColor = UnselectedNavigationColor
    )

    val background = rememberVectorPainter(image = baseBackground)
    val modifier = if (withSplashBackground) {
        Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = listOf(MainOrangeLight, Turquoise)))
    } else {
        Modifier
            .fillMaxSize()
            .paint(painter = background, contentScale = ContentScale.Crop, alignment = Alignment.Center, sizeToIntrinsics = true)
    }

    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = {
            if (isShowNavBar) {
                HorizontalDivider(Modifier.padding(horizontal = 20.dp), 1.dp, UnselectedNavigationColor)
                BottomAppBar(
                    containerColor = Color.Transparent,
                    modifier = Modifier.padding(top = 10.dp)
                ) {
                    NavigationBar(containerColor = Color.Transparent) {
                        bottomBarItems.forEach { item ->
                            CompositionLocalProvider(LocalRippleConfiguration provides NoRippleConfiguration) {
                                val icon = when (item) {
                                    is AppDestinations.Main -> mainIcon
                                    is AppDestinations.InterviewList -> interviewIcon
                                    is AppDestinations.TestsList -> testsIcon
                                    is AppDestinations.NewsList -> newsIcon
                                    else -> mainIcon
                                }
                                val isSelected = currentDestination?.hasRoute(item::class) ?: false
                                NavigationBarItem(
                                    colors = navigationBarItemColors,
                                    icon = {
                                        Icon(
                                            imageVector = icon,
                                            contentDescription = null,
                                            modifier = Modifier.size(32.dp),
                                        )
                                    },
                                    label = { Text(getLabel(destinations = item, isLangRus = langIsRus) ?: "") },
                                    selected = isSelected,
                                    onClick = {
                                        if (!isSelected) {
                                            navController.navigate(item) {
                                                // Сохраняем состояние экрана, с которого уходим
                                                popUpTo(navController.graph.findStartDestination().id) {
                                                    saveState = true
                                                }
                                                // Избегаем создания копий экрана на вершине стека
                                                launchSingleTop = true
                                                // Восстанавливаем состояние (скролл, стейт) при возвращении
                                                restoreState = true
                                            }
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = AppDestinations.Splash
        ) {
            composable<AppDestinations.Main> {
                val mainViewModel = koinInject<MainScreenViewModel>()
                MainScreen(
                    viewModel = mainViewModel,
                    onNavigationAuthorization = {
                        navController.navigate(route = AppDestinations.Authorization) {
                            popUpTo(AppDestinations.Splash) { inclusive = true }
                        }
                    },
                    navController = navController,
                    eventDestination = AppDestinations.EventsInner(),
                    onclickEvents = {
                        navController.navigate(route = AppDestinations.EventsList)
                    },
                    onclickStudy = {
                        navController.navigate(route = AppDestinations.StudyList)
                    }
                )
            }
            composable<AppDestinations.InterviewList> {
                val interviewListViewModel = koinInject<InterviewListScreenViewModel>()
                InterviewListScreen(
                    viewModel = interviewListViewModel,
                    onNavigationAuthorization = {
                        navController.navigate(route = AppDestinations.Authorization) {
                            popUpTo(AppDestinations.Splash) { inclusive = true }
                        }
                    }
                )
            }
            composable<AppDestinations.TestsList> {
                val testsListViewModel = koinInject<TestsListScreenViewModel>()
                TestsListScreen(
                    viewModel = testsListViewModel,
                    onNavigationAuthorization = {
                        navController.navigate(route = AppDestinations.Authorization) {
                            popUpTo(AppDestinations.Splash) { inclusive = true }
                        }
                    }
                )
            }
            composable<AppDestinations.NewsList> {
                val newsListViewModel = koinInject<NewsListScreenViewModel>()
                NewsListScreen(
                    viewModel = newsListViewModel,
                    navController = navController,
                    newsDestination = AppDestinations.NewsInner(),
                    modifier = Modifier.fillMaxSize().padding(innerPadding)
                )
            }
            composable<AppDestinations.NewsInner> {
                backStackEntry ->
                val newsId = backStackEntry.toRoute<AppDestinations.NewsInner>().newsId
                NewsInnerScreen(newsId = newsId,onClickBack = { navController.popBackStack() })
            }
            composable<AppDestinations.Authorization> {
                AuthorizationScreen(
                    onAuthorized = {
                        navController.navigate(route = AppDestinations.Main) {
                            popUpTo(AppDestinations.Authorization) { inclusive = true }
                        }
                    }
                )
            }
            composable<AppDestinations.Professions> {
                ProfileScreen(
                    onNavigationAuthorization = {
                        navController.navigate(route = AppDestinations.Authorization) {
                            popUpTo(AppDestinations.Splash) { inclusive = true }
                        }
                    }
                )
            }

            composable<AppDestinations.Splash> {
                SplashScreen(onNavigateToHome = {
                    navController.navigate(route = AppDestinations.Main) {
                        popUpTo(AppDestinations.Splash) { inclusive = true }
                    }},
                    onNavigationAuthorization = {
                        navController.navigate(route = AppDestinations.Authorization) {
                            popUpTo(AppDestinations.Splash) { inclusive = true }
                        }
                    }
                )
            }
            composable<AppDestinations.EventsList> {
                EventsListScreen(
                    navController = navController,
                    eventDestination = AppDestinations.EventsInner(),
                    onClickBack = { navController.popBackStack() }
                )
            }
            composable<AppDestinations.EventsInner> {
                backStackEntry ->
                val eventId = backStackEntry.toRoute<AppDestinations.EventsInner>().eventId
                EventsInnerScreen(onClickBack = { navController.popBackStack() },
                    eventId = eventId)
            }
            composable<AppDestinations.StudyList> {
                StudyListScreen(onClickBack = { navController.popBackStack() }
                )
            }
        }
    }
}