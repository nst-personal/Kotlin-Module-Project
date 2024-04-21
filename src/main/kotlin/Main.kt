import pages.ExitPage
import pages.Page
import pages.screen.MainScreen
import pages.screen.Screen
import java.util.Scanner

class Application {
    private var currentScreen = MainScreen(0, "Application")
    private var currentPage: Page? = null

    fun start() {
        currentScreen.show()
    }

}

fun main(args: Array<String>) {
    val application = Application()
    application.start()
}