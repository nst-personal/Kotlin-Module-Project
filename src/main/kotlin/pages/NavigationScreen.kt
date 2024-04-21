package pages

import pages.common.ExitPage
import pages.common.Page
import pages.common.Screen
import java.util.Scanner

open class NavigationScreen(index: Int, name: String) : Screen(index, name) {
    protected var currentPage: Page? = null
    protected var previousPage: Page? = null
    open fun action() : Boolean {
        return false
    }
    open fun show() {
        val scanner = Scanner(System.`in`)
        while (true) {
            showPagesOption()
            val valueData = scanner.nextLine()
            val potentialValue = valueData.toIntOrNull();
            if (valueData == null || potentialValue == null) {
                println("Wrong selected element")
            } else {
                val potentialPage = getPage(potentialValue);
                if (potentialPage == null) {
                    println("Wrong selected element")
                } else {
                    if (potentialPage is ExitPage) {
                        println("Bye")
                        break
                    } else {
                        currentPage = potentialPage;
                        val isCompleted = action()
                        if (isCompleted) {
                            break
                        }
                    }
                }
            }
        }
    }
}