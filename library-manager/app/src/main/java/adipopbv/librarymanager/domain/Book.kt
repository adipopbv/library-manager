package adipopbv.librarymanager.domain

class Book(
    var title: String,
    var author: String,
    var series: String,
    var part: Int,
    var pagesCount: Int,
    var publicationYear: Int,
    var publisher: String,
    var genre: String,
    var currentReader: String,
    var location: String
)