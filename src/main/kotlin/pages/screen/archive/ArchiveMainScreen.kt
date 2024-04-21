package pages.screen.archive

import pages.common.ExitPage
import pages.common.EntityScreen

class ArchiveMainScreen(index: Int, name: String) : EntityScreen(index, name) {

    init {
        menuPages = arrayListOf(
            ArchiveMenuPage(0, "Create Archive"),
            ArchiveMenuPage(1, "Show Archive", ArchiveScreen(0, "Note")),
            ExitPage(2, "Exit")
        )
    }

    override fun get() {
        super.get()
        if (entities.isNotEmpty())
            currentPage?.screen?.show()
    }

}