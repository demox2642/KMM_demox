package navigation

object NavigationTree {

    enum class Splash {
        SplashScreen
    }

    enum class Auth {
        AuthFlow, Login, Register, Forgot, Confirm
    }

    enum class Main {
        Dashboard, Home, Search, Events, Streams
    }

    enum class Desktop {
        Dashboard, Games, Events, Create
    }
}
