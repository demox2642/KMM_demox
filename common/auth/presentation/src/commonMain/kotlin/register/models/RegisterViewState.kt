package register.models

data class RegisterViewState(
    val phone: String,
    val password: String,
    val repeatPassword: String,
    val isCreateUser: Boolean = false,
    val passwordHidden: Boolean = true,
    val repeatPasswordHidden: Boolean = true,
    val isSending: Boolean = false,
    val showError: Boolean = false,
    val errorTitle: String = "",
    val errorMessage: String = "",
    val code: Long? = null

)
