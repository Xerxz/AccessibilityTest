package com.xerxz.accessibilitytest.view.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.xerxz.accessibilitytest.view.navigation.BottomNav
import com.xerxz.accessibilitytest.view.navigation.NavScreen

@Composable
fun AccessibilityBottomBar(
    navController: NavController,
    currentRoute: String?
) {
    BottomAppBar(
        modifier = Modifier.clip(RoundedCornerShape(
            topStart = 30.dp,
            topEnd = 30.dp
        )),
        cutoutShape = CircleShape,
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.primary
    ){
        BottomNav.values().forEach { screen ->
            BottomNavigationItem(
                alwaysShowLabel = true,
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = MaterialTheme.colors.secondary,
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = screen.iconId),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(
                        text = screen.screenName,
                        color = MaterialTheme.colors.secondary
                    )
                },
                selected = currentRoute == screen.route,
                onClick = {
                    if (currentRoute == screen.route) {
                        return@BottomNavigationItem
                    }
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route) {
                            NavScreen.Accessibility.route.let { startRoute ->
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }

                },
            )
        }
    }
}
