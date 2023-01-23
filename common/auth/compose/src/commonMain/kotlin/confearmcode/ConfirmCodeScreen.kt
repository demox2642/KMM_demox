package confearmcode

import androidx.compose.runtime.*
import models.RegisterCodeResponse
import widgets.CodeTextField

@Composable
fun ConfirmCodeScreen(codeResponse: RegisterCodeResponse) {
    var otpValue by remember {
        mutableStateOf("")
    }

    CodeTextField(
        otpText = otpValue,
        onOtpTextChange = { value, otpInputFilled ->
            otpValue = value
        }
    )
}
