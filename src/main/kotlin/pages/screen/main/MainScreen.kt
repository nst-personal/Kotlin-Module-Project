package pages.screen.main

import pages.NavigationScreen
import pages.common.ExitPage
import pages.screen.archive.ArchiveMainScreen

class MainScreen(index: Int, name: String) : NavigationScreen(index, name) {
    init {
        menuPages = arrayListOf(
            ArchiveMainScreen(0, "Archive page"),
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
                (this.currentPage as ArchiveMainScreen).show()
            }
        }
        return false
    }

}
