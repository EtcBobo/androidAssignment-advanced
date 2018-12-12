package chia.androidassignment
import android.app.Application
import android.os.Parcelable
import android.view.ContextMenu
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

import java.io.Serializable


class Movie (title:String,desc:String,lang:String,rDate:String,nSuit:Boolean,viol:Boolean,langU:Boolean,var ratingText:String = "",var ratingNo:Float = 0.0f) : Serializable {
    var title:String
    var desc:String
    var lang:String
    var rDate:String
    var nSuit:Boolean
    var viol:Boolean
    var langU:Boolean





    init{
        this.title = title
        this.lang = lang
        this.desc = desc
        this.rDate = rDate
        this.nSuit = nSuit
        this.viol = viol
        this.langU = langU
        this.ratingText = ratingText
        this.ratingNo = ratingNo


    }
}

class MovieList :Application(){
    var theList:ArrayList<Movie>
    var viewList:ArrayList<TextView>

    init{
        this.theList = arrayListOf()
        this.viewList = arrayListOf()
    }
    fun addList(newList:Movie){
        var add = this.theList.add(newList)
    }

    fun addView(newView:TextView){
        var add = this.viewList.add(newView)
    }

    fun getView():ArrayList<TextView>{
        return this.viewList
    }

    fun getList():ArrayList<Movie>{
        return this.theList
    }
    private var singleton: MovieList? = null

    fun getInstance(): MovieList? {
        return singleton
    }

    override fun onCreate() {
        super.onCreate()
        singleton = this
    }

}

class test(menu: EditText?){
    var menuC:EditText? = menu
    fun getMenu():EditText?{
        return menuC
    }
}