package pages.screen.main

import pages.NavigationScreen
import pages.common.ExitPage
import pages.screen.archive.ArchiveMainScreen
import pages.screen.archive.ArchivePageMenu

class MainScreen(index: Int, name: String) : NavigationScreen(index, name) {
    init {
        menuPages = arrayListOf(
            ArchivePageMenu(0, "Archive page", ArchiveMainScreen(0, "Archive page")),
            ExitPage(1, "Exit")
        )
    }
}
