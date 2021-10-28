package adipopbv.librarymanager

import adipopbv.librarymanager.domain.Book
import adipopbv.librarymanager.utils.BookListAdapter
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var booksList: ArrayList<Book>
    private lateinit var adapter: BookListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        listView = findViewById(R.id.books_list)
        booksList = arrayListOf(
            Book(
                "Dune",
                "Frank Herbert",
                "Dune",
                1,
                736,
                2019,
                "Nemira",
                "Science-Fiction",
                "Calin",
                "Adi's room"
            ),
            Book(
                "Ceva",
                "Cineva",
                "Careva",
                2,
                100,
                1990,
                "Nu stiu",
                "Manual de Informatica",
                "Nimeni",
                "Nicaieri"
            )
        )
        adapter = BookListAdapter(this, booksList)
        listView.adapter = adapter

        findViewById<FloatingActionButton>(R.id.add_book_button).setOnClickListener {

        }
    }
}