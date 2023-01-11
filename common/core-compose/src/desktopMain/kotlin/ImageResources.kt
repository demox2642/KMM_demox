import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

actual class ImageResources() {

    actual companion object {
        @Composable
        actual fun icVisible() = painterResource("drawable/ic_visible.xml")

        @Composable
        actual fun icNoVisible() = painterResource("drawable/ic_novisible")
    }
}
