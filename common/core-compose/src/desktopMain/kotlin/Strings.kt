object Strings {
    val password_hint: String
    val phone_hint: String
    val login: String
    val login_screen_title: String
    val forgot_password: String
    val registeration: String
    val back: String
    val platform_name: String
    val pick_password: String
    val repeat_password: String

    init {
        if (System.getProperty("user.language").equals("ru")) {
            password_hint = "Ваш пароль"
            phone_hint = "Ваш телефон"
            login = "Войти"
            login_screen_title = "С возвращением в Demox BanK! Введите свой телефон и пароль."
            forgot_password = "Забыли ПАРОЛЬ"
            registeration = "Зарегистрироваться"
            back = "Назад"
            platform_name = "Desktop"
            pick_password = "Придумайте пароль"
            repeat_password = "Повторите пароль"
        } else {
            password_hint = "Your Password"
            phone_hint = "Your Phone"
            login = "Login Now"
            login_screen_title = "Welcome back to Demox BanK! Enter your phone and password."
            forgot_password = "Forgot PASSWORD"
            registeration = "Register"
            back = "Back"
            platform_name = "Desktop"
            pick_password = "Pick a password"
            repeat_password = "Repeat password"
        }
    }
}
