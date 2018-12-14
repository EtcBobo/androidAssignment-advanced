package chia.androidassignment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.view.*
import android.widget.*
import android.content.Intent
import kotlinx.android.synthetic.main.activity_movie_edit.*

class MovieEdit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_edit)

        val theMovie = intent.getSerializableExtra("newMovie") as Movie
        movTitle?.setText(theMovie.title)

        movDesc?.setText(theMovie.desc)
        tdate?.setText(theMovie.rDate)
        var lang = theMovie.lang
        if (lang == "English"){
            val radio: RadioButton = findViewById(R.id.English)
            radio.isChecked = true
        }
        else if(lang =="Chinese"){
            val radio: RadioButton = findViewById(R.id.Chinese)
            radio.isChecked = true
        }
        else if(lang == "Malay"){
            val radio: RadioButton = findViewById(R.id.Malay)
            radio.isChecked = true
        }
        else{
            val radio: RadioButton = findViewById(R.id.Tamil)
            radio.isChecked = true
        }


        if(theMovie.viol || theMovie.langU){
            var theSuit = findViewById<LinearLayout>(R.id.suit)
            theSuit.setVisibility(View.VISIBLE)
        }

        notSuit.isChecked = theMovie.nSuit
        viol.isChecked = theMovie.viol
        langc.isChecked = theMovie.langU


        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }
    override fun onSupportNavigateUp(): Boolean {
        val theMovie = intent.getSerializableExtra("newMovie") as Movie
        val intent = Intent(this, MovieDetail::class.java)
        intent.putExtra("newMovie",theMovie)
        startActivity(intent)
        return true
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.cancel){
            val theMovie = intent.getSerializableExtra("newMovie") as Movie
            val intent = Intent(this, MovieDetail::class.java)
            intent.putExtra("newMovie",theMovie)
            startActivity(intent)
        }
        if(item?.itemId == R.id.save){
            var id = radioGroup.checkedRadioButtonId
            val radio:RadioButton = findViewById(id)
            var radioT = radio.text.toString()
            val theMovie = Movie(movTitle.text.toString(),movDesc.text.toString(),radioT,tdate.text.toString(),notSuit.isChecked,viol.isChecked,langc.isChecked)
            val movieList = applicationContext as MovieList

            val intentn = Intent(this, MovieDetail::class.java)
            var position =  intent.getIntExtra("position",0)
            movieList.editList(theMovie,position)
            intentn.putExtra("newMovie",theMovie)
            startActivity(intentn)
        }
        return super.onOptionsItemSelected(item)
    }

}
