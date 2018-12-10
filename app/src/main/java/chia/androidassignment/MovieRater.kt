package chia.androidassignment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import kotlinx.android.synthetic.main.activity_movie_rater.*



class MovieRater : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rater)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add,menu)

        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.clear){
            movTitle?.setText("")
            movDesc?.setText("")
            date?.setText("")
            val radio: RadioButton = findViewById(R.id.English)
            radio.isChecked = true

            notSuit.isChecked = false
            viol.isChecked = false
            langc.isChecked = false
            var theSuit = findViewById<LinearLayout>(R.id.suit)
            theSuit.setVisibility(View.INVISIBLE)
        }
        if(item?.itemId == R.id.addMovie){

            var title = movTitle.text.toString()
            var desc = movDesc.text.toString()
            var id: Int = radioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)
            var lang = radio.text.toString()
            var date = date.text.toString()
            var suit = notSuit.isChecked
            var viol = viol.isChecked
            var langU = langc.isChecked
            val newMovie = Movie(title,desc,lang,date,suit,viol,langU)
            val movieL = applicationContext as MovieList
            movieL.addList(newMovie)

            val intent = Intent(this, MovieDetail::class.java)
            intent.putExtra("newMovie", newMovie)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }


    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked
            var theSuit = findViewById<LinearLayout>(R.id.suit)
            when (view.id) {
                R.id.notSuit -> {
                    if (checked) {
                        theSuit.setVisibility(View.VISIBLE)
                    } else {
                        theSuit.setVisibility(View.INVISIBLE)
                    }
                }
            }
        }
    }






}


