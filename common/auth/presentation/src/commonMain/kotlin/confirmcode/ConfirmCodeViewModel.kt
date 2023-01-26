package confirmcode

import com.adeo.kviewmodel.BaseSharedViewModel
import confirmcode.models.ConfirmCodeAction
import confirmcode.models.ConfirmCodeEvent
import confirmcode.models.ConfirmCodeViewState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class ConfirmCodeViewModel : BaseSharedViewModel<ConfirmCodeViewState, ConfirmCodeAction, ConfirmCodeEvent>(
    initialState = ConfirmCodeViewState(code = "", time = "", showToast = true)
) {
    init {

        obtainTimeChanged()
    }

    override fun obtainEvent(viewEvent: ConfirmCodeEvent) {
        when (viewEvent) {
            is ConfirmCodeEvent.ConfirmCodeValue -> obtainCodeChanged(viewEvent.code)
            is ConfirmCodeEvent.ErrorMessage -> showMessage(viewEvent.showError, viewEvent.title, viewEvent.message)
        }
    }

    private fun obtainTimeChanged() {
        val date = Calendar.getInstance()
        val minute = SimpleDateFormat("mm:ss", Locale.getDefault())
        var counter = 0

        viewModelScope.launch {
            date.set(Calendar.SECOND, 0)
            date.set(Calendar.MINUTE, 3)

            while (true) {
                delay(1000)
                counter++
                if (counter > 180) {
                    println("ConfirmVM obtainTimeChanged() counter > 180  ${minute.format(date.time)}")
                } else {
                    if (minute.format(date.time) == "02:55") {
                        viewState = viewState.copy(showToast = false)
                    }
                    date.add(Calendar.SECOND, -1)
                    viewState = viewState.copy(
                        time = minute.format(date.time)
                    )
                }
            }
        }
    }

    private fun obtainCodeChanged(code: String) {
        println("ConfirmVM code=$code")
        viewState = viewState.copy(
            code = code
        )
    }

    private fun showMessage(showError: Boolean, title: String?, message: String?) {
        TODO("Not yet implemented")
    }
}
