package pages.screen

import pages.ExitPage
import pages.Page
import java.util.Scanner

class MainScreen(index: Int, name: String) : Screen(index, name) {
    private var currentPage: Page? = null
    init {
        pages = arrayListOf(
            ArchiveMainScreen(0, "Archive"),
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


    private fun showPagesOption() {
        println("Select item from menu")
        println(name)
        pages.forEach { page ->
            println("${page.index} ${page.name}")
        }
    }

    private fun getPage(index: Int) : Page? {
        return pages.find { page -> page.index == index }
    }
}
