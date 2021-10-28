package adipopbv.librarymanager

import adipopbv.librarymanager.domain.Book
import adipopbv.librarymanager.utils.BookListAdapter
import android.content.res.Resources
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
                "fantasy",
                "novel",
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
                "science-fiction",
                "novel",
                "Calin",
                "Adi's room"
            ),
            Book(
                "Short introduction to Kotlin",
                "Some Guy",
                "Kotlin",
                1,
                100,
                1990,
                "InfoTime",
                "programming",
                "manual",
                "No one",
                "Nowhere"
            )
        )
        adapter = BookListAdapter(this, booksList)
        listView.adapter = adapter
    }
}