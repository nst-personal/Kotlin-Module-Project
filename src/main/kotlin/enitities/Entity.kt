package enitities

open class Entity(var name: String) {
    open fun details(): String {
        return name
    }
}