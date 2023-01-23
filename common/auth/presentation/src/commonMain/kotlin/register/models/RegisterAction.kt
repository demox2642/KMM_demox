package register.models

sealed class RegisterAction {
    object OpenConfirmCodeScreen : RegisterAction()
}
