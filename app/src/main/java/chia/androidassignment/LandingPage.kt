package chia.androidassignment

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle


import android.widget.*

import android.view.*

import android.content.Intent
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_landing_page.*


class LandingPage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)
        var count:Int = 0
        val movieL = applicationContext as MovieList

        val theList = movieL.getList()
        if(theList.isEmpty()){

        }
        else{
            for (i in theList){
                count = count + 1
            }

            for( i in 0 .. count-1) {
                val relativeP = RelativeLayout(this)
                relativeP.layoutParams = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 180)

                val iv = ImageView(this)
                iv.setImageResource(R.drawable.movie)
                val layoutParams = LinearLayout.LayoutParams(150, 150)
                iv.layoutParams = layoutParams

                val tv2 = TextView(this)
                val lptv1 = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
                tv2.setLayoutParams(lptv1)
                tv2.setText(theList[i].title)
                tv2.gravity = Gravity.CENTER
                tv2.setTextSize(16f)

                val tid = 100 + i
                tv2.setId(tid)

                relativeP.removeAllViews()
                relativeP.addView(iv)
                relativeP.addView(tv2)


                val finalParent = this.findViewById(R.id.rootLayout) as ViewGroup

                finalParent.addView(relativeP)
                registerForContextMenu(tv2)

            }
        }
        registerForContextMenu(rootLayout)
    }






    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.land,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.addNew){

            val intent = Intent(this, MovieRater::class.java)
            startActivity(intent)


        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val theTest = applicationContext as Adapter
        if(v?.id == R.id.rootLayout){
            menu?.add(1,1001,1,"Edit")
        }



    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == 1001){
            val intent = Intent(this, MovieEdit::class.java)
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }




}
