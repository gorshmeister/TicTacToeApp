package my.game.tictactoe

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.game.tictactoe.R
import kotlinx.android.synthetic.main.activity_second.*

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_second)

        val anim = AnimationUtils.loadAnimation(applicationContext, R.anim.move)

        var chance = "X"
        val board = arrayListOf<String>("", "", "", "", "", "", "", "", "")

        val firstTextColor = ContextCompat.getColor(applicationContext, R.color.colorMy)
        val secondTextColor = ContextCompat.getColor(applicationContext, R.color.colorComputer)

        fun recordMove(button: Button, position: Int) {
            if (board[position] != "")
            else if (chance == "X") {
                button.text = "X"
                button.setTextColor(firstTextColor)
                board[position] = "X"
                chance = "O"
            } else {
                button.text = "O"
                button.setTextColor(secondTextColor)
                board[position] = "O"
                chance = "X"
            }
        }

        button0.setOnClickListener {
            recordMove(button0, 0)
            resultOut(board)
        }

        button1.setOnClickListener {
            recordMove(button1, 1)
            resultOut(board)
        }

        button2.setOnClickListener {
            recordMove(button2, 2)
            resultOut(board)
        }

        button3.setOnClickListener {
            recordMove(button3, 3)
            resultOut(board)
        }

        button4.setOnClickListener {
            recordMove(button4, 4)
            resultOut(board)
        }

        button5.setOnClickListener {
            recordMove(button5, 5)
            resultOut(board)
        }

        button6.setOnClickListener {
            recordMove(button6, 6)
            resultOut(board)
        }

        button7.setOnClickListener {
            recordMove(button7, 7)
            resultOut(board)
        }

        button8.setOnClickListener {
            recordMove(button8, 8)
            resultOut(board)
        }

        buttonReset.setOnClickListener {
            startActivity(Intent(this@ThirdActivity, ThirdActivity::class.java))
        }

        // back ImageView
        imageViewBack.setOnClickListener {
            startActivity(Intent(this@ThirdActivity, MainActivity::class.java))
        }

    }

    private fun resultOut(board: ArrayList<String>) {
        if (result(board, "X")) {
            startActivity(
                Intent(this@ThirdActivity, WonActivity::class.java).putExtra(
                    "player",
                    "X"
                )
            )
        } else if (result(board, "O")) {
            startActivity(
                Intent(this@ThirdActivity, WonActivity::class.java).putExtra(
                    "player",
                    "O"
                )
            )
        }
        if (isBoardFull(board)) {
            startActivity(
                Intent(this@ThirdActivity, WonActivity::class.java).putExtra(
                    "player",
                    "Tie"
                )
            )
        }
    }

    private fun isBoardFull(board: ArrayList<String>): Boolean {
        for (i in board)
            if (i != "X" && i != "O") return false
        return true
    }

    private fun result(bd: ArrayList<String>, s: String): Boolean =
        if (bd[0] == s && bd[1] == s && bd[2] == s) true
        else if (bd[3] == s && bd[4] == s && bd[5] == s) true
        else if (bd[6] == s && bd[7] == s && bd[8] == s) true
        else if (bd[0] == s && bd[3] == s && bd[6] == s) true
        else if (bd[1] == s && bd[4] == s && bd[7] == s) true
        else if (bd[2] == s && bd[5] == s && bd[8] == s) true
        else if (bd[0] == s && bd[4] == s && bd[8] == s) true
        else if (bd[2] == s && bd[4] == s && bd[6] == s) true
        else false

    // for handling back buttton of the Android Device
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this@ThirdActivity, MainActivity::class.java))
    }

}
