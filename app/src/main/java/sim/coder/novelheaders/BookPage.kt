package sim.coder.novelheaders

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_book_page.*
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.app.ComponentActivity
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.preference.PreferenceManager
import android.view.View
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener


class BookPage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_page)



        val pref= getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = pref.edit()
        var no =pref.getInt("pageno",0)

        pdf.fromAsset("novel.pdf")
            .password(null)
            .defaultPage(no)
            .enableSwipe(true)
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .onPageChange(OnPageChangeListener { page, pageCount ->
                editor.putInt("pageno",page)
                editor.commit()
            })
            .enableAnnotationRendering(true)
            .load()




    }

}
