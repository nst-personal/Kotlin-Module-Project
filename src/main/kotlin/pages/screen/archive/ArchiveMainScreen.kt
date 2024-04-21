package pages.screen.archive

import pages.common.ExitPage
import pages.common.EntityScreen

class ArchiveMainScreen(index: Int, name: String) : EntityScreen(index, name) {

    init {
        val archiveScreen = ArchiveScreen(0, "Note")
        menuPages = arrayListOf(
            ArchiveMenuPage(0, "Create Archive", null),
            ArchiveMenuPage(1, "Show Archive", archiveScreen),
            ExitPage(2, "Exit")
        )
    }

    override fun get() {
        super.get()
        if (!entities.isEmpty()) {
            (currentPage as ArchiveMenuPage).subScreen?.show()
        }
    }

}