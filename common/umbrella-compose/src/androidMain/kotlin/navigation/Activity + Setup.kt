package navigation // ktlint-disable filename

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowInsetsControllerCompat
import com.adeo.kviewmodel.odyssey.setupWithViewModels
import ru.alexgladkov.odyssey.compose.base.Navigator
import ru.alexgladkov.odyssey.compose.extensions.setupWithActivity
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.ModalNavigator
import theme.AppTheme
import theme.AppTheme.AppTheme
import theme.appDarkColors
import theme.appLightColors

fun ComponentActivity.setupThemedNavigation() {
    val rootController = RootComposeBuilder().apply { generateGraph(NavigationSource.Android) }.build()
    rootController.setupWithActivity(this)
    rootController.setupWithViewModels()
    WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightNavigationBars = true
    setContent {
        val darkTheme: Boolean = isSystemInDarkTheme()
        val colors = if (darkTheme) appDarkColors() else appLightColors()

        AppTheme(colors = colors) {
            val backgroundColor = AppTheme.colors.systemBackgroundPrimary
            rootController.backgroundColor = backgroundColor
            this.window.statusBarColor = AppTheme.colors.systemBackgroundPrimary.toArgb()
            this.window.navigationBarColor = AppTheme.colors.systemBackgroundPrimary.toArgb()

            CompositionLocalProvider(
                LocalRootController provides rootController
            ) {
                ModalNavigator {
                    Navigator(startScreen = NavigationTree.Splash.SplashScreen.name)
                }
            }
        }
    }
}