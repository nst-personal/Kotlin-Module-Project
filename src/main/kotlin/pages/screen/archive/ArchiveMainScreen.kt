package pages.screen.archive

import pages.common.ExitPage
import pages.common.EntityScreen
import java.util.Scanner

class ArchiveMainScreen(index: Int, name: String) : EntityScreen(index, name) {

    init {
        menuPages = arrayListOf(
            ArchivePageMenu(0, "Create Archive"),
            ArchivePageMenu(1, "Show Archive", ArchiveScreen(0, "Note")),
            ExitPage(2, "Exit")
        )
    }

    override fun get() {
        if (entities.isNotEmpty()) {
            super.get()
            getNotes()
        } else {
            super.get()
        }
    }

    private fun getNotes() {
        val scanner = Scanner(System.`in`)
        while (true) {
            println("Select item for view (fill exit to back)")
            val valueData = scanner.nextLine()
            val potentialValue = valueData.toIntOrNull();
            if (valueData == null || potentialValue == null) {
                if (valueData?.lowercase().equals("exit")) {
                    break
                }
                println("Wrong selected element")
            } else {
                val item = entities.getOrNull(potentialValue);
                if (item == null) {
                    println("Wrong selected element")
                } else {
                    currentPage?.screen?.show()
                }
            }
        }
    }

}