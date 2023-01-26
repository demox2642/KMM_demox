package dialogs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import theme.AppTheme

@ExperimentalComposeUiApi
@Composable
fun ToastCustom(
    message: String
) {
    Popup(
        popupPositionProvider = object : PopupPositionProvider {
            override fun calculatePosition(
                anchorBounds: IntRect,
                windowSize: IntSize,
                layoutDirection: LayoutDirection,
                popupContentSize: IntSize
            ): IntOffset = IntOffset.Zero
        },
        onDismissRequest = {}

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize().padding(20.dp),
            contentAlignment = androidx.compose.ui.Alignment.BottomCenter
        ) {
            Surface(elevation = 24.dp, shape = RoundedCornerShape(10.dp)) {
                Card(
                    modifier = Modifier.height(50.dp)
                        // .fillMaxWidth()
                        .padding(5.dp),
                    backgroundColor = Color.Blue,
                    contentColor = AppTheme.colors.systemTextOnPrimary
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                    ) {
                        Text(message)
                    }
                }
            }
        }
    }
}
