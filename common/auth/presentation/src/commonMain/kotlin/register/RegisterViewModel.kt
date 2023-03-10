package register

import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.launch
import register.models.RegisterAction
import register.models.RegisterEvent
import register.models.RegisterViewState
import repository.AuthRepository

class RegisterViewModel : BaseSharedViewModel<RegisterViewState, RegisterAction, RegisterEvent>(
    initialState = RegisterViewState(phone = "", password = "", repeatPassword = "")
) {

    private val authRepository: AuthRepository = Inject.instance()
    private fun obtainPhoneChanged(value: String) {
        viewState = viewState.copy(
            phone = value
        )
    }

    private fun obtainPasswordChanged(value: String) {
        viewState = viewState.copy(
            password = value
        )
    }

    private fun obtainRepeatPasswordChanged(value: String) {
        viewState = viewState.copy(
            repeatPassword = value
        )
    }

    private fun showMessage(title: String, message: String) {
        viewState = viewState.copy(
            showError = true,
            errorTitle = title,
            errorMessage = message
        )
    }

    private fun changePasswordVisibility() {
        viewState = viewState.copy(passwordHidden = !viewState.passwordHidden)
        //   viewState = viewState.copy(passwordHidden = !viewState.repeatPasswordHidden)
    }

    override fun obtainEvent(viewEvent: RegisterEvent) {
        when (viewEvent) {
            is RegisterEvent.PhoneChanged -> obtainPhoneChanged(viewEvent.value)
            is RegisterEvent.PasswordChanged -> obtainPasswordChanged(viewEvent.value)
            is RegisterEvent.RepeatPasswordChanged -> obtainRepeatPasswordChanged(viewEvent.value)
            is RegisterEvent.ErrorMessage -> showMessage(viewEvent.title!!, viewEvent.message!!)
            is RegisterEvent.PasswordShowClick -> changePasswordVisibility()
            is RegisterEvent.UserCreateClick -> createUser()
        }
    }

    private fun createUser() {
        if (viewState.password == viewState.repeatPassword) {
            viewModelScope.launch {
                val response = authRepository.register(phone = viewState.phone.toLong(), password = viewState.password)
                if (response.success) {
                    viewState = viewState.copy(code = response.response.code)
                    viewAction = RegisterAction.OpenConfirmCodeScreen
                } else {
                    showMessage("Create user ERROR", "zasdfg")
                }
            }
        }
    }
}
