package ci.nsu.moble.main.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ci.nsu.moble.main.R
import android.graphics.Color as col

class MainFragment : Fragment() {

    private val  colorMap = mapOf(
        "red" to col.RED,
        "blue" to col.BLUE,
        "green" to col.GREEN,
        "yellow" to col.YELLOW,
        "cyan" to col.CYAN,
        "magenta" to col.MAGENTA
    )

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editText = view.findViewById<EditText>(R.id.editTextText)
        val button = view.findViewById<Button>(R.id.button)
        val layout = view.findViewById<LinearLayout>(R.id.linearLayout)

        button.setOnClickListener {
            val input = editText.text.toString().trim().lowercase()

            val color = colorMap[input]

            if (color != null) {
                button.setBackgroundColor(color)
                Log.d("log", "Цвет применен")
            }
            else {
                Log.e("eror", "Цвет не сществует")
            }
        }

        for (e in colorMap.entries) {
            val name = e.key
            val color = e.value

            val textView = TextView(requireContext())
            textView.setText(name)
            textView.setBackgroundColor(color)

            layout.addView(textView)
        }
    }
}