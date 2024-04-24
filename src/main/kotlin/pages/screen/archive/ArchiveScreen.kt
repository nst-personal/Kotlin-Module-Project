package pages.screen.archive

import enitities.Entity
import pages.NavigationScreen
import pages.common.ExitPage
import pages.screen.notes.NoteMainScreen
import pages.screen.notes.NotePageMenu

class ArchiveScreen(index: Int, name: String, screenEntities: ArrayList<Entity>) : NavigationScreen(index, name) {

    init {
        menuPages = arrayListOf(
            NotePageMenu(0, "Note Page", NoteMainScreen(0, "Notes", screenEntities)),
            ExitPage(1, "Exit")
        )
    }
}