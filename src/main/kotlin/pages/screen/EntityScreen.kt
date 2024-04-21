package pages.screen

import enitities.Entity

abstract class EntityScreen(index: Int, name: String) : Screen(index, name) {
    var entities: ArrayList<Entity> = arrayListOf()
    abstract fun add()
    protected fun get() {
        println("$name ===> Items:")
        entities.forEach { item ->
            println("${item.name}")
        }
    }
    protected fun showPagesOption() {
        println("$name: Select item from menu")
        pages.forEach { page ->
            println("${page.index} ${page.name}")
        }
    }
}