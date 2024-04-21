package pages.common

import enitities.Archive
import enitities.Entity
import java.util.Scanner

abstract class EntityScreen(index: Int, name: String) : Screen(index, name) {
    protected var entities: ArrayList<Entity> = arrayListOf()
    protected var currentPage: Page? = null
    protected var previousPage: Page? = null
    protected open fun get() {
        println("$name ===> Items:")
        if (entities.isEmpty()) {
            println("No elements")
        } else {
            entities.forEachIndexed { index, item ->
                println("${index + 1}. ${item.name}")
            }
        }
    }
    protected fun add() {
        val scanner = Scanner(System.`in`)
        while (true) {
            println("$name ===> Fill name")
            val name = scanner.nextLine()
            if (name == null || name.trim().isEmpty()) {
                println("Name is not provided")
            } else {
                entities.add(Archive(name))
                break
            }
        }
    }

    override fun show() {
        while (true) {
            showPagesOption()
            val scanner = Scanner(System.`in`)
            val valueData = scanner.nextLine()
            val potentialValue = valueData.toIntOrNull();
            if (valueData == null || potentialValue == null) {
                println("Wrong selected menu item")
            } else {
                val potentialPage = getPage(potentialValue);
                if (potentialPage == null) {
                    println("Wrong selected element")
                } else {
                    previousPage = currentPage
                    currentPage = potentialPage
                    when(currentPage?.index) {
                        0 -> {
                            add()
                        }
                        1 -> {
                            get()
                        }
                        2 -> {
                            break;
                        }
                    }
                }
            }
        }
    }

}