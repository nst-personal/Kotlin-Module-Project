package pages.screen.notes

import enitities.Entity
import pages.NavigationScreen
import pages.common.ExitPage

class NoteScreen(index: Int, name: String, private var item: Entity) : NavigationScreen(index, name) {

    init {
        menuPages = arrayListOf(
            ExitPage(0, "Exit")
        )
    }

    override fun showDetails() {
        println("=================")
        println("${item.details()}")
        println("=================")
    }

}