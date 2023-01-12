package login


import ImageResources
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import login.models.LoginAction
import login.models.LoginEvent
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.core.LaunchFlag
import theme.AppTheme
import widgets.ActionButton
import widgets.CommonTextField

@Composable
fun LoginScreen() {
    val rootController = LocalRootController.current


    StoredViewModel(factory = { LoginViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        Column(
            modifier = Modifier.padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = StringResources.stLogin(),
                color = AppTheme.colors.systemTextPrimary,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(top = 15.dp),
                text = StringResources.stLoginScreenTitle(),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = AppTheme.colors.systemTextPrimary
            )

            Spacer(modifier = Modifier.height(50.dp))

            CommonTextField(
                value = state.value.phone,
                placeholder = StringResources.stPhoneHint(),
                isSending = state.value.isSending,
                trailingIcon = {}
            ) {
                viewModel.obtainEvent(LoginEvent.PhoneChanged(it))
            }

            Spacer(modifier = Modifier.height(24.dp))

            CommonTextField(
                value = state.value.password,
                placeholder = StringResources.stPasswordHint(),
                isSending = state.value.isSending,
                isTextHidden = state.value.passwordHidden,
                trailingIcon = {
                    Icon(
                        modifier = Modifier.clickable {
                            viewModel.obtainEvent(LoginEvent.PasswordShowClick)
                        },
                        painter =  if (state.value.passwordHidden) {
                            ImageResources.icNoVisible()
                        } else {
                            ImageResources.icVisible()
                        },
                        contentDescription = null,
                        tint = AppTheme.colors.controlGraphBlue
                    )


                }
            ) {
                viewModel.obtainEvent(LoginEvent.PasswordChanged(it))
            }

            Spacer(modifier = Modifier.height(20.dp))
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                TextButton(onClick = {viewModel.obtainEvent(LoginEvent.ForgotClick)})
                {
                    Text(StringResources.stForgotPassword())
                }
                TextButton(onClick = {viewModel.obtainEvent(LoginEvent.RegistrationClick)}){
                    Text(StringResources.stRegisteration())
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            ActionButton(title = StringResources.stLogin(), isSending = state.value.isSending) {
                viewModel.obtainEvent(LoginEvent.LoginClick)
            }
        }

        when (action.value) {
            is LoginAction.OpenMainFlow -> rootController.findRootController().present(
                screen = NavigationTree.Main.Dashboard.name,
                launchFlag = LaunchFlag.SingleNewTask
            )

            is LoginAction.OpenRegistrationScreen -> rootController.push(NavigationTree.Auth.Register.name)
            is LoginAction.OpenForgotPasswordScreen -> rootController.push(NavigationTree.Auth.Forgot.name)
            null -> { }
        }
    }
}
