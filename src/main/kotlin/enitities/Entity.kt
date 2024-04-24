package enitities

open class Entity(var name: String) {
    var subItems: ArrayList<Entity>? = null

    open fun details(): String {
        return name
    }
}