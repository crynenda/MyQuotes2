package de.sensis.crynenda.myquotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.*

class MainActivity : AppCompatActivity() {

    val quotes = listOf(
        Quote(
            "Probleme kann man niemals mit derselben Denkweise lösen, durch die sie entstanden sind.",
            "-- Albert Einstein",
            "*1879  †1955"
        ),
        Quote(
            "Man braucht nichts im Leben zu fürchenten, man muss nur alles verstehen.",
            "-- Marie Curie",
            "*1867  †1934"
        ),
        Quote(
            "Nichts ist so beständig wie der Wandel",
            "-- Heraklit",
            "* um 520 v.Chr.  † um 460 v.Chr."
        ),
        Quote(
            "Arbeit schafft Hornhaut gegen den Kummer.",
            "-- Marcus Tullius Cicero",
            "*106 v.Chr.  † 43 v.Chr."
        ),
        Quote(
            "Habe Mut Dich Deines eigenen Verstandes zu bedienen!",
            "-- Immanuel Kant",
            "*1724  † 1804"
        ),
        Quote(
            "Steuern sind ein erlaubter Fall von Raub.",
            "-- Thomas von Aquin",
            "*1224  † 1274"
        )
    )


    // ohne Typenangabe autom. Integer
    private var index = 0

    private lateinit var quoteText: TextView
    private lateinit var quoteAuthor: TextView
    private lateinit var quoteYear: TextView
    private lateinit var quoteNext: Button
    private lateinit var quotePrevious: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        quoteText = findViewById(R.id.txt_quote_text)
        quoteAuthor = findViewById(R.id.txt_quote_author)
        quoteYear = findViewById(R.id.txt_quote_year)
        quoteNext = findViewById(R.id.btn_next)
        quotePrevious = findViewById(R.id.btn_prev)


        setQuote(index)
        setVisibilityButtons()
    }

    private fun setVisibilityButtons() {
        when (index) {
            0 -> quotePrevious.visibility = View.INVISIBLE
            quotes.size - 1 -> quoteNext.visibility = View.INVISIBLE
            else -> {
                quotePrevious.visibility = View.VISIBLE
                quoteNext.visibility = View.VISIBLE
            }
        }
    }


    // Java: public nextQuote(View view) {..}
    fun nextQuote(view: View) {

        if (index < quotes.lastIndex) {
            index++
        } else {
            index = 0
        }
        setQuote(index)

        makeToast("Nächstes Zitat")
    }

    // Java: public previousQuote(View view) {..}
    fun previousQuote(view: View) {

        if (index == 0) {
            index = quotes.lastIndex
        } else {
            index--
        }
        setQuote(index)

        makeToast("Voriges Zitat")
    }

    private fun setQuote(index: Int) {
        quoteText.text = quotes[index].text
        quoteAuthor.text = quotes[index].author
        quoteYear.text = quotes[index].year
    }

    private fun makeToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
