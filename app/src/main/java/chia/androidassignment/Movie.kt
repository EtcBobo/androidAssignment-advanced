package chia.androidassignment
import android.os.Parcelable
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