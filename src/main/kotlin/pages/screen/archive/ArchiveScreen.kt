package pages.screen.archive

import pages.common.ExitPage
import pages.common.Screen
import pages.screen.notes.NoteMainScreen
import java.util.Scanner

class ArchiveScreen(index: Int, name: String) : Screen(index, name) {

    init {
        menuPages = arrayListOf(
            NoteMainScreen(0, "Note Page"),
            ExitPage(1, "Exit")
        )
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
                    if (potentialPage is ExitPage) {
                        break
                    } else {
                        potentialPage.show()
                    }
                }
            }
        }
    }
}