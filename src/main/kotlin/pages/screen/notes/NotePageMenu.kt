package pages.screen.notes

import pages.NavigationScreen
import pages.common.Page

class NotePageMenu(index: Int, name: String) : Page(index, name) {
    constructor(index: Int, name: String, screen: NavigationScreen) : this(index, name) {
        this.screen = screen
    }
}