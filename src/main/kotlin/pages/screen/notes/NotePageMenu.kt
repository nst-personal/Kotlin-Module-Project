package pages.screen.notes

import pages.NavigationScreen
import pages.common.EntityScreen

class NotePageMenu(index: Int, name: String) : EntityScreen(index, name) {
    constructor(index: Int, name: String, screen: NavigationScreen) : this(index, name) {
        this.screen = screen
    }
}