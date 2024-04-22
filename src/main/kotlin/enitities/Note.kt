package enitities

class Note(name: String, var text: String) : Entity(name) {
    override fun details(): String {
        return "$name $text"
    }
}