package sim.coder.novelheaders

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val SharedPreferences = getSharedPreferences("page", Context.MODE_PRIVATE)
        SharedPreferences.edit()

        btn_readBook.setOnClickListener {
            var i = Intent(Intent(this, BookPage::class.java))
            startActivity(i)

            val pref=getSharedPreferences("pref", Context.MODE_PRIVATE)

            Toast.makeText(this, "جيل يقراء", Toast.LENGTH_LONG).show()
        }

    }
}
