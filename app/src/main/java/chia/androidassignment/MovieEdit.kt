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
        val theMovie = Movie("Venom","OverView","English","19-10-2018",true,true,false)
        movTitle?.setText(theMovie.title)

        movDesc?.setText(theMovie.desc)
        tdate?.setText(theMovie.rDate)

        val radio: RadioButton = findViewById(R.id.English)
        radio.isChecked = true

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
        val theMovie = Movie("Venom","OverView","English","19-10-2018",true,true,false)
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
            val theMovie = Movie("Venom","OverView","English","19-10-2018",true,true,false)
            val intent = Intent(this, MovieDetail::class.java)
            intent.putExtra("newMovie",theMovie)
            startActivity(intent)
        }
        if(item?.itemId == R.id.save){
            var id = radioGroup.checkedRadioButtonId
            val radio:RadioButton = findViewById(id)
            var radioT = radio.text.toString()
            val theMovie = Movie(movTitle.text.toString(),movDesc.text.toString(),radioT,tdate.text.toString(),notSuit.isChecked,viol.isChecked,langc.isChecked)
            val intent = Intent(this, MovieDetail::class.java)
            intent.putExtra("newMovie",theMovie)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

}
