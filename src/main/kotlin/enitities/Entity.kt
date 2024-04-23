package enitities

open class Entity(var name: String) {
    var subItems: ArrayList<Entity>? = null
    constructor(name: String, subItems: ArrayList<Entity>) : this(name) {
        this.subItems = subItems
    }

    open fun details(): String {
        return name
    }
}