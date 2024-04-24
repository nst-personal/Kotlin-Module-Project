package pages.screen.archive

import pages.NavigationScreen
import pages.common.Page

class ArchivePageMenu(index: Int, name: String) : Page(index, name) {
    constructor(index: Int, name: String, screen: NavigationScreen) : this(index, name) {
        this.screen = screen
    }
}