package navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import theme.AppTheme

@Composable
fun TopAppNavBar() {
    val rootController = LocalRootController.current

    if (StringResources.getPlatformName() == "Desktop") {
        Row(modifier = Modifier.fillMaxWidth()) {
            IconButton(
                onClick = { rootController.popBackStack() }

            ) {
                Icon(
                    ImageResources.icNoVisible(),
                    contentDescription = StringResources.stBack(),
                    tint = AppTheme.colors.systemGraphPrimary
                )
            }
        }
    }
}
