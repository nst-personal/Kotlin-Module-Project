package pages.screen.notes

import pages.common.EntityScreen
import pages.common.ExitPage

class NoteMainScreen(index: Int, name: String) : EntityScreen(index, name) {

    init {
        menuPages = arrayListOf(
            NotePageMenu(0, "Create Note"),
            NotePageMenu(1, "Show Note"),
            ExitPage(2, "Exit")
        )
    }

}