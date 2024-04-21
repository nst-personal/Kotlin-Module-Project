package pages.common

abstract class Screen(index: Int, name: String) : Page(index, name) {
    var menuPages = arrayListOf<Page>()
    protected fun getPage(index: Int) : Page? {
        return menuPages.find { page -> page.index == index }
    }

    protected fun showPagesOption() {
        println("$name ===> Select item from menu")
        menuPages.forEach { page ->
            println("${page.index} ${page.name}")
        }
    }
}