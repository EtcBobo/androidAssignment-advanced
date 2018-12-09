package chia.androidassignment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_movie_rating.*

class MovieRating : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rating)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.rating,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.submit){
            var ratingText = ratingText.text.toString()
            var ratingNo = ratingBar.rating
            val newMovie = intent.getSerializableExtra("newMovie") as Movie
            newMovie.ratingText = ratingText
            newMovie.ratingNo = ratingNo
            val intent = Intent(this, MovieDetail::class.java)
            intent.putExtra("newMovie", newMovie)
            startActivity(intent)

        }
        return super.onOptionsItemSelected(item)
    }
}
