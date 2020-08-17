package sim.coder.novelheaders

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("")

        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        ad_view.loadAd(adRequest)





        val SharedPreferences = getSharedPreferences("page", Context.MODE_PRIVATE)
        SharedPreferences.edit()

        btn_readBook.setOnClickListener {
            var i = Intent(Intent(this, BookPage::class.java))
            startActivity(i)


            Toast.makeText(this, "جيل يقراء", Toast.LENGTH_LONG).show()
        }

    }



    public override fun onPause() {
        ad_view.pause()
        super.onPause()
    }

    // Called when returning to the activity
    public override fun onResume() {
        super.onResume()
        ad_view.resume()
    }

    // Called before the activity is destroyed
    public override fun onDestroy() {
        ad_view.destroy()
        super.onDestroy()
    }




}
