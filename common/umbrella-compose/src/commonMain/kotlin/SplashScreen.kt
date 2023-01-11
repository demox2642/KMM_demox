import androidx.compose.runtime.Composable
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun SplashScreen() {
    val rootController = LocalRootController.current
    println("in SplashScreen")
    rootController.present(NavigationTree.Auth.AuthFlow.name)
}
