package pages.screen

import pages.common.EntityScreen
import java.util.Scanner

abstract class ItemMainScreen(index: Int, name: String) : EntityScreen(index, name) {
    protected fun getItem() {
        val scanner = Scanner(System.`in`)
        while (true) {
            super.get()
            displayExit()
            println("Select item for view")
            val valueData = scanner.nextLine()
            val potentialValue = valueData.toIntOrNull()
            if (valueData == null || potentialValue == null) {
                println("Wrong selected element")
            } else {
                if (potentialValue == getExitNumber()) {
                    break
                }
                val index = potentialValue - 1
                val item = entities.getOrNull(index)
                if (item == null) {
                    println("Wrong selected element")
                } else {
                    currentPage?.screen = getNoteScreenBasedOnMenuItem(index, item)
                    currentPage?.screen?.show()
                }
            }
        }
    }
}