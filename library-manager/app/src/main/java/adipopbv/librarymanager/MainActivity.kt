package adipopbv.librarymanager

import adipopbv.librarymanager.domain.Book
import adipopbv.librarymanager.utils.BookListAdapter
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageButton
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var booksList: ArrayList<Book>
    private lateinit var adapter: BookListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val addBookPanel: ConstraintLayout = findViewById(R.id.add_book_panel)
        addBookPanel.visibility = GONE
        findViewById<FloatingActionButton>(R.id.add_book_button).setOnClickListener {
            addBookPanel.visibility = VISIBLE
        }
        findViewById<ImageButton>(R.id.cancel_button).setOnClickListener {
            // also reset fields
            addBookPanel.visibility = GONE
        }
        findViewById<ImageButton>(R.id.accept_button).setOnClickListener {
            // also reset fields
            addBookPanel.visibility = GONE
            // add book
            booksList.add(Book(
                "Tronul de Foc",
                "Rick Riordan",
                "Cronicile familiei Cane",
                2,
                480,
                2014,
                "Editura Arthur",
                "Fantasy",
                "Nimeni",
                "Adi's room"
            ))
            adapter.notifyDataSetChanged()
        }

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
    }
}