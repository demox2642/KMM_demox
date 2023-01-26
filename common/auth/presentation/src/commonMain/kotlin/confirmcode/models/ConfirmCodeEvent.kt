package confirmcode.models

sealed class ConfirmCodeEvent {
    data class ConfirmCodeValue(val code: String) : ConfirmCodeEvent()
    data class ErrorMessage(val showError: Boolean = false, val title: String? = "", val message: String? = "") : ConfirmCodeEvent()
}
