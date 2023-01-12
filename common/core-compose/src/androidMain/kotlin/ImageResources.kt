import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.demox.bank.core_compose.R

actual class ImageResources() {

    actual companion object {
        @Composable
        actual fun icVisible() = painterResource(R.drawable.ic_visible)

        @Composable
        actual fun icNoVisible() = painterResource(R.drawable.ic_novisible)

        @Composable
        actual fun icArrowLeft() = painterResource(R.drawable.ic_arrow_left)
    }
}
