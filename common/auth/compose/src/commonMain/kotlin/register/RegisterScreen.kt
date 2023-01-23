package register

import ImageResources
import StringResources
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import models.RegisterCodeResponse
import navigation.NavigationTree
import navigation.TopAppNavBar
import register.models.RegisterAction
import register.models.RegisterEvent
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import theme.AppTheme
import widgets.ActionButton
import widgets.CommonTextField

@Composable
fun RegisterScreen() {


    val rootController = LocalRootController.current


    StoredViewModel(factory = { RegisterViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        Column(
            modifier = Modifier.padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                TopAppNavBar()
            }

            CommonTextField(
                value = state.value.phone,
                placeholder = StringResources.stPhoneHint(),
                isSending = state.value.isSending,
                trailingIcon = {}
            ) {
                viewModel.obtainEvent(RegisterEvent.PhoneChanged(it))
            }

            Spacer(modifier = Modifier.height(24.dp))

            CommonTextField(
                value = state.value.password,
                placeholder = StringResources.stPickPassword(),
                isSending = state.value.isSending,
                isTextHidden = state.value.passwordHidden,
                trailingIcon = {
                    Icon(
                        modifier = Modifier.clickable {
                            viewModel.obtainEvent(RegisterEvent.PasswordShowClick)
                        },
                        painter = if (state.value.passwordHidden) {
                            ImageResources.icNoVisible()
                        } else {
                            ImageResources.icVisible()
                        },
                        contentDescription = null,
                        tint = AppTheme.colors.controlGraphBlue
                    )
                }
            ) {
                viewModel.obtainEvent(RegisterEvent.PasswordChanged(it))
            }

            Spacer(modifier = Modifier.height(24.dp))

            CommonTextField(
                value = state.value.repeatPassword,
                placeholder = StringResources.stRepeatPassword(),
                isSending = state.value.isSending,
                isTextHidden = state.value.passwordHidden,
                trailingIcon = {
                    Icon(
                        modifier = Modifier.clickable {
                            viewModel.obtainEvent(RegisterEvent.PasswordShowClick)
                        },
                        painter = if (state.value.passwordHidden) {
                            ImageResources.icNoVisible()
                        } else {
                            ImageResources.icVisible()
                        },
                        contentDescription = null,
                        tint = AppTheme.colors.controlGraphBlue
                    )
                }
            ) {
                viewModel.obtainEvent(RegisterEvent.RepeatPasswordChanged(it))
            }

            Spacer(modifier = Modifier.height(40.dp))

            ActionButton(title = StringResources.stRegisteration(), isSending = state.value.isSending) {
                viewModel.obtainEvent(RegisterEvent.UserCreateClick)
            }
        }
        when (action.value) {
            is RegisterAction.OpenConfirmCodeScreen-> rootController.push(NavigationTree.Auth.Confirm.name, params = RegisterCodeResponse(phone = state.value.phone.toLong(),code = state.value.code!! ) )
            null -> { }
        }
    }


}
