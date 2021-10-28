package adipopbv.librarymanager.utils

import adipopbv.librarymanager.R
import adipopbv.librarymanager.domain.Book
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.TextView
import android.animation.ValueAnimator
import androidx.cardview.widget.CardView


class BookListAdapter(
    private val context: Context,
    private val dataSource: ArrayList<Book>
) : BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val book = getItem(position) as Book
        val bookView = inflater.inflate(R.layout.book_list_item, parent, false)
        val titleTextView = bookView.findViewById<TextView>(R.id.book_title)
        val bookCard = bookView.findViewById<CardView>(R.id.book_card)
        bookView.findViewById<ImageButton>(R.id.expand_button).setOnClickListener {
            if (bookCard.height == 80.px) {
                val anim = ValueAnimator.ofInt(bookCard.measuredHeight, 500.px)
                anim.addUpdateListener { valueAnimator ->
                    val `val` = valueAnimator.animatedValue as Int
                    val layoutParams: ViewGroup.LayoutParams = bookCard.layoutParams
                    layoutParams.height = `val`
                    bookCard.layoutParams = layoutParams
                }
                anim.start()
            } else {
                val anim = ValueAnimator.ofInt(bookCard.measuredHeight, 80.px)
                anim.addUpdateListener { valueAnimator ->
                    val `val` = valueAnimator.animatedValue as Int
                    val layoutParams: ViewGroup.LayoutParams = bookCard.layoutParams
                    layoutParams.height = `val`
                    bookCard.layoutParams = layoutParams
                }
                anim.start()
            }
        }
        bookView.findViewById<ImageButton>(R.id.delete_button).setOnClickListener {
            dataSource.remove(book)
            notifyDataSetChanged()
//            Log.d("info", "delete")
//            Log.d("info", dataSource.size.toString())
        }
        titleTextView.text = book.title

        return bookView
    }}