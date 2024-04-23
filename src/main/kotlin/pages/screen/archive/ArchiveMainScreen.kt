package pages.screen.archive

import enitities.Archive
import enitities.Entity
import pages.NavigationScreen
import pages.common.ExitPage
import pages.common.EntityScreen
import java.util.Scanner

class ArchiveMainScreen(index: Int, name: String) : EntityScreen(index, name) {

    init {
        menuPages = arrayListOf(
            ArchivePageMenu(0, "Create Archive"),
            ArchivePageMenu(1, "Show Archive"),
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

    override fun getNoteScreenBasedOnMenuItem(index: Int, item: Entity) : NavigationScreen? {
        if (index == getExitNumber()) {
            return null
        }
        return ArchiveScreen(0, "Note for " + item.name, item.subItems!!)
    }

    private fun getNotes() {
        val scanner = Scanner(System.`in`)
        while (true) {
            super.get()
            displayExit()
            println("Select item for view")
            val valueData = scanner.nextLine()
            val potentialValue = valueData.toIntOrNull()
            if (valueData == null || potentialValue == null) {
                println("Wrong selected element")
            } else {
                if (potentialValue == getExitNumber()) {
                    break
                }
                val index = potentialValue - 1
                val item = entities.getOrNull(index)
                if (item == null) {
                    println("Wrong selected element")
                } else {
                    currentPage?.screen = getNoteScreenBasedOnMenuItem(index, item)
                    currentPage?.screen?.show()
                }
            }
        }
    }

}