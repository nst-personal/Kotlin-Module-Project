package pages.screen.archive

import pages.NavigationScreen
import pages.common.ExitPage
import pages.screen.notes.NoteMainScreen

class ArchiveScreen(index: Int, name: String) : NavigationScreen(index, name) {

    init {
        menuPages = arrayListOf(
            NoteMainScreen(0, "Note Page"),
            ExitPage(1, "Exit")
        )
    }

    override fun action(): Boolean {
        if (this.currentPage == null) {
            println("Wrong selected element")
        } else {
            if (this.currentPage is ExitPage) {
                return true
            } else {
                (this.currentPage as NoteMainScreen).show()
            }
        }
        return false
    }

}