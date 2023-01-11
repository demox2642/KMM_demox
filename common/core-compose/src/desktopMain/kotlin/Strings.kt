object Strings {
    val password_hint: String
    val phone_hint: String
    val login: String
    val login_screen_title: String

    init {
        if (System.getProperty("user.language").equals("ru")) {
            password_hint = "Ваш пароль"
            phone_hint = "Ваш телефон"
            login = "Войти"
            login_screen_title = "С возвращением в Demox BanK! Введите свой телефон и пароль."
        } else {
            password_hint = "Your Password"
            phone_hint = "Your Phone"
            login = "Login Now"
            login_screen_title = "Welcome back to Demox BanK! Enter your phone and password."
        }
    }
}
