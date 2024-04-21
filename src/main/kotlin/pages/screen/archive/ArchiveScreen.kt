package pages.screen.archive

import pages.NavigationScreen
import pages.common.ExitPage
import pages.screen.notes.NoteMainScreen
import pages.screen.notes.NotePageMenu

class ArchiveScreen(index: Int, name: String) : NavigationScreen(index, name) {

    init {
        menuPages = arrayListOf(
            NotePageMenu(0, "Note Page", NoteMainScreen(0, "Notes")),
            ExitPage(1, "Exit")
        )
    }

    override fun action(): Boolean {
        if (this.currentPage is ExitPage) {
            return true
        }
        this.currentPage?.screen?.show()
        return false
    }

}