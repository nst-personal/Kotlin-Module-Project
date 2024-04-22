package pages.screen.archive

import enitities.Archive
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
            getNotes()
        } else {
            super.get()
        }
    }

    override fun add() {
        addField("Name") { fieldValue ->
            entities.add(Archive(fieldValue))
        }
    }

    private fun getExitNumber() : Int {
        return entities.size + 1
    }

    private fun displayExit() {
        println("${getExitNumber()}. Exit")
    }

    private fun getNotes() {
        val scanner = Scanner(System.`in`)
        while (true) {
            super.get()
            displayExit()
            println("Select item for view")
            val valueData = scanner.nextLine()
            val potentialValue = valueData.toIntOrNull();
            if (valueData == null || potentialValue == null) {
                println("Wrong selected element")
            } else {
                if (potentialValue == getExitNumber()) {
                    break
                }
                val item = entities.getOrNull((potentialValue - 1));
                if (item == null) {
                    println("Wrong selected element")
                } else {
                    currentPage?.screen?.show()
                }
            }
        }
    }

}