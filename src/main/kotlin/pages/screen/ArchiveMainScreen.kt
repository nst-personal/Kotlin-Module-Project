package pages.screen

import enitities.Archive
import pages.ArchivePage
import pages.ExitPage
import pages.Page
import java.util.Scanner

class ArchiveMainScreen(index: Int, name: String) : EntityScreen(index, name) {

    init {
        pages = arrayListOf(
            ArchivePage(0, "Create Archive"),
            ArchivePage(1, "Show Archive"),
            ExitPage(2, "Exit")
        )
    }


    private var currentPage: Page? = null
    private var previousPage: Page? = null

    override fun add() {
        val scanner = Scanner(System.`in`)
        while (true) {
            println("Fill name")
            val name = scanner.nextLine()
            if (name == null || name.trim().isEmpty()) {
                println("Archive should have name")
            } else {
                entities.add(Archive(name))
                break
            }
        }
    }

    override fun show() {
        while (true) {
            showPagesOption()
            val scanner = Scanner(System.`in`)
            val valueData = scanner.nextLine()
            val potentialValue = valueData.toIntOrNull();
            if (valueData == null || potentialValue == null) {
                println("Wrong selected menu item")
            } else {
                val potentialPage = getPage(potentialValue);
                if (potentialPage == null) {
                    println("Wrong selected element")
                } else {
                    previousPage = currentPage
                    currentPage = potentialPage
                    when(currentPage?.index) {
                        0 -> {
                            add()
                            break
                        }
                        1 -> {
                            get()
                            break
                        }
                        2 -> {
                            println("Bye")
                            break;
                        }
                    }
                }
            }
        }
    }
    private fun getPage(index: Int) : Page? {
        return pages.find { page -> page.index == index }
    }
}