package confirmcode.models

sealed class ConfirmCodeAction {
    object OpenMainFlowNavigation : ConfirmCodeAction()
    object ShowError : ConfirmCodeAction()
    object ShowCodeToast : ConfirmCodeAction()
}
