package ci.nsu.mobile.main.ui.main

import android.content.Intent
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ci.nsu.mobile.main.R
import com.google.android.material.appbar.MaterialToolbar
import androidx.navigation.fragment.findNavController
import ci.nsu.mobile.main.SecondActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class SecondFragment : Fragment() {

    companion object {
        fun newInstance() = SecondFragment()
    }

    private val viewModel: SecondViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val topAppBar = view.findViewById<MaterialToolbar>(R.id.topAppBar)

        topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        // BottomNavigationView
        val bottomNav = view.findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                MenuDestination.Main.id -> {
                    // ничего не делаем
                    findNavController().popBackStack()
                }
                MenuDestination.Second.id -> {
                    // открываем SecondActivity, как кнопка Transfer
                }
            }
            true
        }
    }
}