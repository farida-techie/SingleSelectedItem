package com.malkinfo.singleselecteditem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {
    var selectedIndex = 0
    val langNames = arrayOf(
        "Python","HTML","Java","C++","SQL","Kotlin","C Language","JavaScript"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       /** ok now run it*/
    }

    fun selectedItem(view: View) {
        var selectItem = langNames[selectedIndex]
        /**set the Material Dialog Box*/
        val langDialog = MaterialAlertDialogBuilder(this)
        langDialog.setTitle("Programming Languages")
        langDialog.setSingleChoiceItems(langNames,selectedIndex){
            dialog,which->
            selectedIndex = which
            selectItem = langNames[which]
        }
        langDialog.setPositiveButton("Ok"){
            dialog,which->
            textMassage("$selectItem is Selected")
        }
        langDialog.setNeutralButton("CanCel"){
            dialog,which->
            dialog.dismiss()
        }
        /**set Dialog show*/
        langDialog.show()
    }
    private fun textMassage(mag:String){
        Toast.makeText(this,mag,Toast.LENGTH_SHORT).show()
    }
}