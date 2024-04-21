package pages.screen

import pages.Page

abstract class Screen(index: Int, name: String) : Page(index, name) {
    var pages = arrayListOf<Page>()
}