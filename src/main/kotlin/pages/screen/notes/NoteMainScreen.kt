package pages.screen.notes

import pages.common.EntityScreen
import pages.common.ExitPage

class NoteMainScreen(index: Int, name: String) : EntityScreen(index, name) {

    init {
        menuPages = arrayListOf(
            NoteMenuPage(0, "Create Note"),
            NoteMenuPage(1, "Show Note"),
            ExitPage(2, "Exit")
        )
    }

}