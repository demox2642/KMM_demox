package register.models

sealed class RegisterEvent {
    data class PhoneChanged(val value: String) : RegisterEvent()
    data class PasswordChanged(val value: String) : RegisterEvent()
    data class RepeatPasswordChanged(val value: String) : RegisterEvent()
    data class ErrorMessage(val showError: Boolean = false, val title: String? = "", val message: String? = "") : RegisterEvent()
    object PasswordShowClick : RegisterEvent()
    object UserCreateClick : RegisterEvent()
}
