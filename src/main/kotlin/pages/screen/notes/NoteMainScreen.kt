package pages.screen.notes

import enitities.Entity
import enitities.Note
import pages.NavigationScreen
import pages.common.EntityScreen
import pages.common.ExitPage
import java.util.Scanner

class NoteMainScreen(index: Int, name: String, private var screenEntities: ArrayList<Entity>) : EntityScreen(index, name) {

    init {
        super.entities = this.screenEntities
    }

    override fun get() {
        if (entities.isNotEmpty()) {
            getNote()
        } else {
            super.get()
        }
    }

    override fun add() {
        var name: String? = null
        addField("Name") { fieldValue ->
            name = fieldValue
        }
        addField("Text") { text ->
            entities.add(Note(name!!, text))
        }
    }

    init {
        menuPages = arrayListOf(
            NotePageMenu(0, "Create Note"),
            NotePageMenu(1, "Show Note"),
            ExitPage(2, "Exit")
        )
    }

    private fun getNote() {
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

    override fun getNoteScreenBasedOnMenuItem(index: Int, item: Entity) : NavigationScreen? {
        if (index == getExitNumber()) {
            return null
        }
        return NoteScreen(0, "Note for " + item.name + " - Details", item)
    }

}