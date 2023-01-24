package navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import theme.AppTheme

@Composable
fun TopAppNavBar() {
    val rootController = LocalRootController.current

    if (StringResources.getPlatformName() == "Desktop") {
        Row(modifier = Modifier.fillMaxWidth().height(100.dp)) {
            IconButton(
                onClick = { rootController.popBackStack() }

            ) {
                Icon(
                    ImageResources.icArrowLeft(),
                    contentDescription = StringResources.stBack(),
                    tint = AppTheme.colors.systemGraphPrimary
                )
            }
        }
    }
}
