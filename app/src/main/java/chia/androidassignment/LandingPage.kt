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
        registerForContextMenu(listView)
        val movie = applicationContext as MovieList


        if(movie.getList().isNotEmpty()) {
            val adapter = Adapter(applicationContext, movie.getList())
            listView.adapter = adapter
            listView.setOnItemClickListener { parent, view, position, id ->
                val intent = Intent(applicationContext,MovieDetail::class.java)
                var theList = movie.getList()
                intent.putExtra("newMovie",theList[position])
                startActivity(intent)
            }

        }




    }
    class Adapter(private val context: Context,
                  private val dataSource: ArrayList<Movie>) : BaseAdapter() {

        private val inflater: LayoutInflater
                = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

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

            val rowView = inflater.inflate(R.layout.listview, parent, false)
            val movie = getItem(position) as Movie
            var title = rowView.findViewById(R.id.theTitle) as TextView
            title.text = movie.title
//
            val thumbnailImageView = rowView.findViewById(R.id.imageMovie) as ImageView
            thumbnailImageView.setImageResource(R.drawable.movie)

            return rowView
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.land,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val intent = Intent(applicationContext,MovieRater::class.java )
        startActivity(intent)
        return super.onOptionsItemSelected(item)

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if(v?.id == R.id.listView){
            menu?.add(1,1001,1,"Edit")
        }
    }


    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val movie = applicationContext as MovieList
        val intent = Intent(this@LandingPage,MovieEdit::class.java )

        val info = item?.menuInfo as AdapterView.AdapterContextMenuInfo
        if (item.itemId==1001){
            var position = info.id.toInt()
            var movList = movie.getList()
            intent.putExtra("newMovie",movList[position])
            intent.putExtra("position",position)
            startActivity(intent)
        }

        return super.onContextItemSelected(item)

    }



}