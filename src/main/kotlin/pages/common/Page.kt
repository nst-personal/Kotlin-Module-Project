package pages.common

import pages.NavigationScreen

abstract class Page(var index: Int, var name: String) {
    var screen: NavigationScreen? = null
}