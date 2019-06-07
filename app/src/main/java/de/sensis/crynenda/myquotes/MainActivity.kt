package de.sensis.crynenda.myquotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

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
        )
    )


    // ohne Typenangabe autom. Integer
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setQuote(index)
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
        findViewById<TextView>(R.id.txt_quote_text).text = quotes[index].text
        findViewById<TextView>(R.id.txt_quote_author).text = quotes[index].author
        findViewById<TextView>(R.id.txt_quote_year).text = quotes[index].year
    }

    private fun makeToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
