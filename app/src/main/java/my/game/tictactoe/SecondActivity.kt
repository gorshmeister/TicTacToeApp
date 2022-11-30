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
import java.util.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_second)

        val anim = AnimationUtils.loadAnimation(applicationContext, R.anim.move)


        val board = arrayListOf<String>("", "", "", "", "", "", "", "", "")

        val myTextColor = ContextCompat.getColor(applicationContext, R.color.colorMy)

        fun recordMyMove(button: Button, boardPosition: Int) {
            if (board[boardPosition] == "") {
                button.text = "X"
                button.setTextColor(myTextColor)
                board[boardPosition] = "X"
                if (!isBoardFull(board) && !result(board, "X")) {
                    val position = getComputerMove(board)
                    board[position] = "O"
                    displayComputerButton(position)
                }
            }
        }

        button0.setOnClickListener {
            recordMyMove(button0, 0)
            resultOut(board)
        }

        button1.setOnClickListener {
            recordMyMove(button1, 1)
            resultOut(board)
        }

        button2.setOnClickListener {
            recordMyMove(button2, 2)
            resultOut(board)
        }

        button3.setOnClickListener {
            recordMyMove(button3, 3)
            resultOut(board)
        }

        button4.setOnClickListener {
            recordMyMove(button4, 4)
            resultOut(board)
        }

        button5.setOnClickListener {
            recordMyMove(button5, 5)
            resultOut(board)
        }

        button6.setOnClickListener {
            recordMyMove(button6, 6)
            resultOut(board)
        }

        button7.setOnClickListener {
            recordMyMove(button7, 7)
            resultOut (board)
        }

        button8.setOnClickListener {
            recordMyMove(button8,8)
            resultOut(board)
        }

        buttonReset.setOnClickListener {
            startActivity(Intent(this@SecondActivity, SecondActivity::class.java))
        }

        // back ImageView
        imageViewBack.setOnClickListener {
            startActivity(Intent(this@SecondActivity, MainActivity::class.java))
        }

    }

    private fun getComputerMove(board: ArrayList<String>): Int {

        //check if computer can win in this move
        for (i in 0..board.count() - 1) {
            val copy: ArrayList<String> = getBoardCopy(board)
            if (copy[i] == "") copy[i] = "O"
            if (result(copy, "O")) return i
        }

        //check if player could win in the next move
        for (i in 0..board.count() - 1) {
            val copy2 = getBoardCopy(board)
            if (copy2[i] == "") copy2[i] = "X"
            if (result(copy2, "X")) return i
        }

        //try to take corners if its free
        val move = choseRandomMove(board, arrayListOf<Int>(0, 2, 6, 8))
        if (move != -1) return move

        //try to take center if its free
        if (board[4] == "") return 4

        //move on one of the sides
        return choseRandomMove(board, arrayListOf<Int>(1, 3, 5, 7))
    }


    private fun choseRandomMove(board: ArrayList<String>, list: ArrayList<Int>): Int {
        val possibleMoves = arrayListOf<Int>()
        for (i in list) {
            if (board[i] == "") possibleMoves.add(i)
        }
        if (possibleMoves.isEmpty()) return -1
        else {
            val index = Random().nextInt(possibleMoves.count())
            return possibleMoves[index]
        }
    }

    private fun getBoardCopy(board: ArrayList<String>): ArrayList<String> {
        val bd = arrayListOf<String>("", "", "", "", "", "", "", "", "")
        for (i in 0..board.count() - 1) {
            bd[i] = board[i]
        }
        return bd
    }

    private fun isBoardFull(board: ArrayList<String>): Boolean {
        for (i in board) if (i != "X" && i != "O") return false
        return true
    }


    private fun resultOut(board: ArrayList<String>) {
        if (result(board, "X")) {
            startActivity(
                Intent(this@SecondActivity, WonActivity::class.java).putExtra(
                    "player", "YOU"
                )
            )
        } else if (result(board, "O")) {
            startActivity(
                Intent(this@SecondActivity, WonActivity::class.java).putExtra(
                    "player", "COMPUTER"
                )
            )
        }
        if (isBoardFull(board)) {
            startActivity(
                Intent(this@SecondActivity, WonActivity::class.java).putExtra(
                    "player", "Tie"
                )
            )
        }
    }


    private fun result(bd: ArrayList<String>, s: String): Boolean =
        if (bd[0] == s && bd[1] == s && bd[2] == s) true
        else if (bd[3] == s && bd[4] == s && bd[5] == s) true
        else if (bd[6] == s && bd[7] == s && bd[8] == s) true
        else if (bd[0] == s && bd[3] == s && bd[6] == s) true
        else if (bd[1] == s && bd[4] == s && bd[7] == s) true
        else if (bd[2] == s && bd[5] == s && bd[8] == s) true
        else if (bd[0] == s && bd[4] == s && bd[8] == s) true
        else bd[2] == s && bd[4] == s && bd[6] == s


    private fun displayComputerButton(position: Int) {
        when (position) {
            0 -> button0.text = "O"
            1 -> button1.text = "O"
            2 -> button2.text = "O"
            3 -> button3.text = "O"
            4 -> button4.text = "O"
            5 -> button5.text = "O"
            6 -> button6.text = "O"
            7 -> button7.text = "O"
            8 -> button8.text = "O"
        }
    }


    // for handling back buttton of the Android Device
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this@SecondActivity, MainActivity::class.java))
    }

}
