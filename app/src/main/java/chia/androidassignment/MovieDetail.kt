package chia.androidassignment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_movie_detail.*
import android.content.Intent

class MovieDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)


        val newMovie = intent.getSerializableExtra("newMovie") as Movie
        if(newMovie.ratingText == "" && newMovie.ratingText == ""){
            reviews.setText("No Reviews yet.\nLong press here to add your review")
        }
        else{
            reviews.setText(newMovie.ratingText)
            var theBar = findViewById<RatingBar>(R.id.ratingBarD)

            theBar.setVisibility(View.VISIBLE)
            theBar.setRating(newMovie.ratingNo)
        }

        val title: TextView = findViewById(R.id.title) as TextView
        title.text = newMovie.title
        val overview: TextView = findViewById(R.id.overview) as TextView
        overview.text = newMovie.desc
        val language: TextView = findViewById(R.id.language) as TextView
        language.text = newMovie.lang
        val date: TextView = findViewById(R.id.date) as TextView
        date.text = newMovie.rDate
        if(newMovie.langU || newMovie.viol){
            if(newMovie.langU && newMovie.viol){
                suit.setText("No (Language and Violance)")
            }
            else if(newMovie.langU){
                suit.setText("No (Language)")
            }
            else if (newMovie.viol){
                theSuit.setText("No (Violence)")
            }

        }
        else{
            suit.setText("Yes")
        }
        registerForContextMenu(reviews)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {


        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        var some = ""
        val intent = Intent(this, LandingPage::class.java)
        intent.putExtra("newMovie", some)
        startActivity(intent)
        return true
    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if(v?.id == R.id.reviews){
            menu?.add(1,1005,1,"Add Review")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == 1005){
            val newMovie = intent.getSerializableExtra("newMovie") as Movie
            val intent = Intent(this, MovieRating::class.java)
            intent.putExtra("newMovie",newMovie)
            startActivity(intent)
        }

        return super.onContextItemSelected(item)
    }


}
