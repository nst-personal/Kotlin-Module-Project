package pages.screen.notes

import enitities.Entity
import enitities.Note
import pages.common.EntityScreen
import pages.common.ExitPage

class NoteMainScreen(index: Int, name: String, private var screenEntities: ArrayList<Entity>) : EntityScreen(index, name) {

    init {
        super.entities = this.screenEntities
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
            NotePageMenu(1, "Show Note", NoteScreen(0, "Note")),
            ExitPage(2, "Exit")
        )
    }

}