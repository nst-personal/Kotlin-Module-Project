package pages.screen.notes

import enitities.Entity
import enitities.Note
import pages.NavigationScreen
import pages.common.ExitPage
import pages.screen.ItemMainScreen

class NoteMainScreen(index: Int, name: String, private var screenEntities: ArrayList<Entity>) : ItemMainScreen(index, name) {

    init {
        super.entities = this.screenEntities
    }

    override fun get() {
        if (entities.isNotEmpty()) {
            getItem()
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

    override fun getNoteScreenBasedOnMenuItem(index: Int, item: Entity) : NavigationScreen? {
        if (index == getExitNumber()) {
            return null
        }
        return NoteScreen(0, "Note for " + item.name + " - Details", item)
    }

}