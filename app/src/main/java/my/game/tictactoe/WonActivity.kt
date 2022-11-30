package my.game.tictactoe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.game.tictactoe.R
import kotlinx.android.synthetic.main.activity_won.*

class WonActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_won)

        val player = intent.getStringExtra("player")
        if (player == "Tie") textViewWon.text = "TIE"
        else textViewWon.text = "$player\nWON"

        val anim = AnimationUtils.loadAnimation(applicationContext, R.anim.zoom)
        textViewWon.startAnimation(anim)
        Handler().postDelayed({
            startActivity(Intent(this@WonActivity, MainActivity::class.java))
        }, 3000)
    }
}
