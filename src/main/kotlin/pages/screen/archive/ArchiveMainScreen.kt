package pages.screen.archive

import enitities.Archive
import enitities.Entity
import pages.NavigationScreen
import pages.common.ExitPage
import pages.screen.ItemMainScreen

class ArchiveMainScreen(index: Int, name: String) : ItemMainScreen(index, name) {

    init {
        menuPages = arrayListOf(
            ArchivePageMenu(0, "Create Archive"),
            ArchivePageMenu(1, "Show Archive"),
            ExitPage(2, "Exit")
        )
    }

    override fun get() {
        if (entities.isNotEmpty()) {
            getItem()
        } else {
            super.get()
        }
    }

    override fun add() {
        addField("Name") { fieldValue ->
            entities.add(Archive(fieldValue))
        }
    }

    override fun getNoteScreenBasedOnMenuItem(index: Int, item: Entity) : NavigationScreen? {
        if (index == getExitNumber()) {
            return null
        }
        return ArchiveScreen(0, "Note for " + item.name, item.subItems!!)
    }

}