package confirmcode.models

data class ConfirmCodeViewState(
    var code: String,
    var time: String,
    var showToast: Boolean
    //   val errorMessage: Boolean = false
)
