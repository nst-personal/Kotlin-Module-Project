package pages.common

import enitities.Archive
import enitities.Entity
import pages.NavigationScreen
import java.util.Scanner

abstract class EntityScreen(index: Int, name: String) : NavigationScreen(index, name) {
    protected var entities: ArrayList<Entity> = arrayListOf()
    protected open fun get() {
        println("$name ===> Items:")
        if (entities.isEmpty()) {
            println("No elements")
        } else {
            entities.forEachIndexed { index, item ->
                println("${index + 1}. ${item.details()}")
            }
        }
    }
    abstract fun add()

    protected fun addField(fieldName: String, callback: (String) -> Unit) {
        val scanner = Scanner(System.`in`)
        while (true) {
            println("$name ===> Fill $fieldName")
            val name = scanner.nextLine()
            if (name == null || name.trim().isEmpty()) {
                println("$fieldName is not provided")
            } else {
                callback(name)
                break
            }
        }
    }

    override fun action() : Boolean {
        when(currentPage?.index) {
            0 -> {
                add()
                return false
            }
            1 -> {
                get()
                return false
            }
            2 -> {
                return true
            }
        }
        return true
    }

}