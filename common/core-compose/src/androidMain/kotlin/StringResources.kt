import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.demox.bank.core_compose.R

actual class StringResources {
    actual companion object {
        @Composable
        actual fun stPasswordHint() = stringResource(id = R.string.password_hint)

        @Composable
        actual fun stPhoneHint() = stringResource(id = R.string.phone_hint)

        @Composable
        actual fun stLogin() = stringResource(id = R.string.login)

        @Composable
        actual fun stLoginScreenTitle() = stringResource(id = R.string.login_screen_title)

        @Composable
        actual fun stForgotPassword() = stringResource(id = R.string.forgot_password)

        @Composable
        actual fun stRegisteration() = stringResource(id = R.string.registeration)
    }
}
