package my.game.tictactoe

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.annotation.RequiresApi
import com.game.tictactoe.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        setContentView(R.layout.activity_main)

        val animZoom2 = AnimationUtils.loadAnimation(applicationContext, R.anim.zoom2)
        val animBlink = AnimationUtils.loadAnimation(applicationContext, R.anim.blink)
        imgTicTacToe.startAnimation(animBlink)


        btnSingle.setOnClickListener{
            btnSingle.startAnimation(animZoom2)
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
        }

        btnMulti.setOnClickListener{
            btnMulti.startAnimation(animZoom2)
            startActivity(Intent(this@MainActivity, ThirdActivity::class.java))
        }

        imgTicTacToe.setOnClickListener{
            imgTicTacToe.startAnimation(animBlink)
        }


        // back ImageView
        imageViewBack.setOnClickListener {
            finish()
            moveTaskToBack(true)
        }

    }

    // for handling back button of the Android Device
    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true)
    }

}
