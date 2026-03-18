package ci.nsu.mobile.main

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ci.nsu.mobile.main.ui.main.SecondFragment

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SecondFragment.Companion.newInstance())
                .commitNow()
        }

        val message = intent.getStringExtra("message")

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = message
    }
}