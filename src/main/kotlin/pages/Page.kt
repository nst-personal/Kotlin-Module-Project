package pages

abstract class Page(val index: Int, val name: String) {
    abstract fun show()
}