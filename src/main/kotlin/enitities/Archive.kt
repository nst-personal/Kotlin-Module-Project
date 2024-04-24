package enitities

class Archive(name: String) : Entity(name) {
    init {
        subItems = arrayListOf()
    }
}
