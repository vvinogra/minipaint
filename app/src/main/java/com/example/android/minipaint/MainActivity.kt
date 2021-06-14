package com.example.android.minipaint

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {
    private lateinit var myCanvasView: MyCanvasView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myCanvasView = MyCanvasView(this)

        setContentView(myCanvasView)
        myCanvasView.contentDescription = getString(R.string.canvasContentDescription)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            WindowCompat.setDecorFitsSystemWindows(window, true)

            WindowCompat.getInsetsController(window, myCanvasView)?.run {
                hide(WindowInsetsCompat.Type.statusBars() or WindowInsetsCompat.Type.navigationBars())
                systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
    }
}