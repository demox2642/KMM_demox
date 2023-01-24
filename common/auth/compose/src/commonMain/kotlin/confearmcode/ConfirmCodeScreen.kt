package confearmcode

import StringResources
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import models.RegisterCodeResponse
import theme.AppTheme
import widgets.CodeTextField

@Composable
fun ConfirmCodeScreen(codeResponse: RegisterCodeResponse) {
    var otpValue by remember {
        mutableStateOf("")
    }
    println(codeResponse.toString())

    Column(
        modifier = Modifier.padding(30.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = StringResources.stLogin(),
            color = AppTheme.colors.systemTextPrimary,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(50.dp))

        CodeTextField(
            modifier = Modifier.focusable(false).onKeyEvent { false },
            otpText = otpValue,
            onOtpTextChange = { value, otpInputFilled ->
                otpValue = value
            }
        )
    }
}
