@file:OptIn(ExperimentalComposeUiApi::class)

package confearmcode

import StringResources
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import confirmcode.ConfirmCodeViewModel
import confirmcode.models.ConfirmCodeEvent
import dialogs.ToastCustom
import models.RegisterCodeResponse
import theme.AppTheme
import widgets.CodeTextField
import java.util.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ConfirmCodeScreen(codeResponse: RegisterCodeResponse) {

    println(codeResponse.toString())

    val scope = rememberCoroutineScope()

    StoredViewModel(factory = { ConfirmCodeViewModel() }) { viewModel ->

        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

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
                otpText = state.value.code,
                onOtpTextChange = { value, otpInputFilled ->
                    val regex = Regex("[^0-9]")
                    viewModel.obtainEvent(ConfirmCodeEvent.ConfirmCodeValue(regex.replace(value, "")))
                },
                modifier = Modifier.focusable(true)
            )

            Spacer(modifier = Modifier.height(50.dp))
            Text(text = state.value.time)
            if (state.value.showToast) {
                ToastCustom(message = "code: " + codeResponse.code.toString())
            }
        }
    }
}
