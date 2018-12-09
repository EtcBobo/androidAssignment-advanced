package chia.androidassignment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle


import android.widget.*

import android.view.*

import android.content.Intent
import android.widget.LinearLayout




class LandingPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)


//        val newMovie = intent.getSerializableExtra("newMovie") as Movie


        for( i in 0 .. 5) {
            val relativeP = RelativeLayout(this)
            relativeP.layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 180)

            val iv = ImageView(this)
            iv.setImageResource(R.drawable.movie)
            val layoutParams = LinearLayout.LayoutParams(150, 150)
            iv.layoutParams = layoutParams

            val tv2 = EditText(this)
            val lptv1 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
            tv2.setLayoutParams(lptv1)
            tv2.setText("Avengers")
            tv2.gravity = Gravity.CENTER
            tv2.setTextSize(16f)
            tv2.isEnabled = false
            val id = 100 + i
            tv2.setId(id)

            relativeP.removeAllViews()
            relativeP.addView(iv)
            relativeP.addView(tv2)

            val finalParent = this.findViewById(R.id.rootLayout) as ViewGroup

            finalParent.addView(relativeP)


        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.land,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.addNew){
            val movieL: MutableList<Movie> = mutableListOf()
            val testM = Movie("Venom","OverView","English","19-10-2018",true,true,false)
            movieL.add(testM)
            var testing = movieL[0]


            val intent = Intent(this, MovieDetail::class.java)
            var thetest = arrayListOf<Movie>()
            thetest.add(testM)
            Toast.makeText(this,thetest[0].title,Toast.LENGTH_LONG).show()
            intent.putExtra("test",thetest)
            startActivity(intent)


        }
        return super.onOptionsItemSelected(item)
    }




}
