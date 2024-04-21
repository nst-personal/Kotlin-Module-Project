package pages.screen.main

import pages.common.ExitPage
import pages.common.Page
import pages.common.Screen
import pages.screen.archive.ArchiveMainScreen
import java.util.Scanner

class MainScreen(index: Int, name: String) : Screen(index, name) {
    private var currentPage: Page? = null
    init {
        menuPages = arrayListOf(
            ArchiveMainScreen(0, "Archive page"),
            ExitPage(1, "Exit")
        )
    }

    override fun show() {
        val scanner = Scanner(System.`in`)
        while (true) {
            showPagesOption()
            val valueData = scanner.nextLine()
            val potentialValue = valueData.toIntOrNull();
            if (valueData == null || potentialValue == null) {
                println("Wrong selected element")
            } else {
                val potentialPage = getPage(potentialValue);
                if (potentialPage == null) {
                    println("Wrong selected element")
                } else {
                    if (potentialPage is ExitPage) {
                        println("Bye")
                        break
                    } else {
                        currentPage = potentialPage;
                        currentPage!!.show()
                    }
                }
            }
        }
    }
}
