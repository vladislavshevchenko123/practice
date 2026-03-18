package ci.nsu.mobile.main.ui.main

import android.content.Intent
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.appbar.MaterialToolbar
import ci.nsu.mobile.main.R
import ci.nsu.mobile.main.SecondActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Кнопка Transfer открывает SecondActivity через Intent
        val transferButton = view.findViewById<Button>(R.id.transferButton)
        transferButton.setOnClickListener {
            activity?.let {
                val intent = Intent(activity, SecondActivity::class.java)
                intent.putExtra("message", "Привет с первого экрана")
                it.startActivity(intent)
            }
        }

        // TopBar стрелку назад пока оставим без NavController
        val topAppBar = view.findViewById<MaterialToolbar>(R.id.topAppBar)
        topAppBar.setNavigationOnClickListener {
            // Просто завершить Activity, если нужно
            activity?.finish()
        }


        // BottomNavigationView
        val bottomNav = view.findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                MenuDestination.Main.id -> {
                    // ничего не делаем
                }
                MenuDestination.Second.id -> {
                    // открываем SecondActivity, как кнопка Transfer
                    activity?.let {
                        val intent = Intent(activity, SecondActivity::class.java)
                        intent.putExtra("message", "Привет с первого экрана")
                        it.startActivity(intent)
                    }
                }
            }
            true
        }
    }

    fun OpenSecond() {

    }
}