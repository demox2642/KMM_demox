package register

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import login.LoginViewModel
import navigation.TopAppNavBar
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun RegisterScreen() {
    TopAppNavBar()

    val rootController = LocalRootController.current


    StoredViewModel(factory = { LoginViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()
    }
}