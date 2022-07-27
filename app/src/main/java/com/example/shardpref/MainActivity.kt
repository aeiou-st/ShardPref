package com.example.shardpref

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var textView2: TextView
    private lateinit var button: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var editText: EditText
    private lateinit var editText2: EditText
    var sharedPrefObj: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.Tv1)
        textView2 = findViewById(R.id.Tv2)
//        button = findViewById(R.id.saveBtn)
//        button2 = findViewById(R.id.clearBtn)
//        button3 = findViewById(R.id.viewBtn)
        editText = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)

        sharedPrefObj = getSharedPreferences("yourData", MODE_PRIVATE)

    }

    fun SaveDataToPreference(view: View)
    {
        //Fetching the values from the Edit Text Field
        val name = editText.text.toString()
        val email = editText2.text.toString()
       
        val editor: SharedPreferences.Editor = sharedPrefObj!!.edit()
        //Now since both of our data is string hence I will use putString() method
        editor.putString("Name", name)
        editor.putString("Email", email)
        //After doing the changes, we need to apply them to the preferences
        //This is a necessary step because if you don't apply, then
        //the changes won't reflect
        editor.apply()
    }
    fun clearDataFromPreference(view :View){
        val name = sharedPrefObj!!.getString("","")
        val email = sharedPrefObj!!.getString("","")
        Toast.makeText(this@MainActivity, "Name : $name\n Phone : $email",
            Toast.LENGTH_LONG).show()
    }

    fun showDataFromPreference(view: View)
    {
        //When user wants to see the data stored in preferences
        //Now let's fetch the data stored in preferences
        val name = sharedPrefObj!!.getString("Name", "No Value")
        val email = sharedPrefObj!!.getString("Email", "No Value")
        //Now, let's display the results to the user
        Toast.makeText(this@MainActivity, "Name : $name\n Phone : $email",
            Toast.LENGTH_LONG).show()
    }

//    override fun onResume() {
//        super.onResume()
//        val SharedPreferences: SharedPreferences =
//            this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
//        button.setOnClickListener {
//            View.OnClickListener {
//                val editText: String = editText.text.toString()
//                val editText2: String = editText2.text.toString()
//                val editor: SharedPreferences.Editor = SharedPreferences.edit()
//                editor.putString("name_key", editText)
//                editor.putString("email_key", editText2)
//                editor.apply()
//                editor.commit()
//            }
//        }
//        button3.setOnClickListener {
//
//            val sharedNameValue = SharedPreferences.getString("name_key", editText.text.toString())
//            val sharedEmailValue = SharedPreferences.getString("email_key", editText2.text.toString())
//            if (sharedNameValue.equals("name_key") && sharedEmailValue.equals("email_key")) {
//                textView.setText("NAME IS:${sharedNameValue}").toString()
//                textView2.setText("ANOTHER NAME IS:${sharedEmailValue}").toString()
//            } else {
//                textView.setText(sharedNameValue).toString()
//                textView2.setText(sharedEmailValue).toString()
//            }
//        }
//    }

//    override fun onPause() {
//        super.onPause()
//        val sharedPreferences = getSharedPreferences("newprefrences", MODE_PRIVATE)
//        val myEdit = sharedPreferences.edit()
//        // write all the data entered by the user in SharedPreference and apply
//        myEdit.putString("name", editText.getText().toString())
//        myEdit.putString("email", editText2.getText().toString())
//        myEdit.apply()
//    }
}



