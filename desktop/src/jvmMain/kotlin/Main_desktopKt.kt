import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import navigation.NavigationSource
import navigation.NavigationTree
import navigation.generateGraph
import ru.alexgladkov.odyssey.compose.base.Navigator
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.ModalNavigator
import theme.AppTheme
import java.awt.Dimension
import java.awt.Toolkit

fun main() = application {
    val icon = icAppRounded()
    val rootController = RootComposeBuilder().apply {
        generateGraph(NavigationSource.Desktop)
    }.build()

    PlatformSDK.init(
        configuration = PlatformConfiguration()
    )

    Window(
        onCloseRequest = ::exitApplication,
        title = "Demox bank. Client",
        visible = true,

        state = WindowState(
            position = WindowPosition.Aligned(Alignment.Center),
            size = getPreferredWindowSize(800, 1000)
        ),
        icon = icon
    ) {
        CompositionLocalProvider(
            LocalRootController provides rootController
        ) {
            AppTheme.AppTheme {
                val backgroundColor = AppTheme.colors.systemBackgroundPrimary
                rootController.backgroundColor = backgroundColor

                ModalNavigator {
                    Navigator(startScreen = NavigationTree.Splash.SplashScreen.name)
                }
            }
        }
    }
}

fun getPreferredWindowSize(desiredWidth: Int, desiredHeight: Int): DpSize {
    val screenSize: Dimension = Toolkit.getDefaultToolkit().screenSize
    val preferredWidth: Int = (screenSize.width * 0.8f).toInt()
    val preferredHeight: Int = (screenSize.height * 0.8f).toInt()
    val width: Int = if (desiredWidth < preferredWidth) desiredWidth else preferredWidth
    val height: Int = if (desiredHeight < preferredHeight) desiredHeight else preferredHeight
    return DpSize(width.dp, height.dp)
}
