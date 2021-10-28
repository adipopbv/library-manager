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
import android.view.animation.RotateAnimation
import androidx.cardview.widget.CardView
import android.view.animation.LinearInterpolator
import android.view.animation.Animation
import java.util.Collections.rotate




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
        // fill in fields
        bookView.findViewById<TextView>(R.id.book_title).text = book.title
        bookView.findViewById<TextView>(R.id.book_author).text = book.author
        bookView.findViewById<TextView>(R.id.book_part).text = OrdinalNumberConverter.toOrdinalString(book.part)
        bookView.findViewById<TextView>(R.id.book_series).text = book.series
        bookView.findViewById<TextView>(R.id.book_genre).text = book.genre
        bookView.findViewById<TextView>(R.id.book_type).text = book.type
        bookView.findViewById<TextView>(R.id.book_year).text = book.publicationYear.toString()
        bookView.findViewById<TextView>(R.id.book_publisher).text = book.publisher
        bookView.findViewById<TextView>(R.id.book_pages).text = book.pagesCount.toString()
        bookView.findViewById<TextView>(R.id.book_reader).text = book.currentReader
        bookView.findViewById<TextView>(R.id.book_location).text = book.location
        // animate expansion
        val bookCard = bookView.findViewById<CardView>(R.id.book_card)
        val expandButton = bookView.findViewById<ImageButton>(R.id.expand_button)
        expandButton.setOnClickListener {
            if (bookCard.height == 80.px) {
                val heightAnimator = ValueAnimator.ofInt(bookCard.measuredHeight, 500.px)
                heightAnimator.addUpdateListener { valueAnimator ->
                    val `val` = valueAnimator.animatedValue as Int
                    val layoutParams: ViewGroup.LayoutParams = bookCard.layoutParams
                    layoutParams.height = `val`
                    bookCard.layoutParams = layoutParams
                }
                val rotateAnimation = RotateAnimation(
                    0f,
                    -180f,
                    Animation.RELATIVE_TO_SELF,
                    0.5f,
                    Animation.RELATIVE_TO_SELF,
                    0.5f
                )
                rotateAnimation.duration = 200
                rotateAnimation.interpolator = LinearInterpolator()
                rotateAnimation.fillAfter = true
                heightAnimator.start()
                expandButton.startAnimation(rotateAnimation)
            } else {
                val heightAnimator = ValueAnimator.ofInt(bookCard.measuredHeight, 80.px)
                heightAnimator.addUpdateListener { valueAnimator ->
                    val `val` = valueAnimator.animatedValue as Int
                    val layoutParams: ViewGroup.LayoutParams = bookCard.layoutParams
                    layoutParams.height = `val`
                    bookCard.layoutParams = layoutParams
                }
                val rotateAnimation = RotateAnimation(
                    -180f,
                    0f,
                    Animation.RELATIVE_TO_SELF,
                    0.5f,
                    Animation.RELATIVE_TO_SELF,
                    0.5f
                )
                rotateAnimation.duration = 200
                rotateAnimation.interpolator = LinearInterpolator()
                rotateAnimation.fillAfter = true
                heightAnimator.start()
                expandButton.startAnimation(rotateAnimation)
            }
        }
        // delete book
        bookView.findViewById<ImageButton>(R.id.delete_button).setOnClickListener {
            dataSource.remove(book)
            notifyDataSetChanged()
        }

        return bookView
    }}