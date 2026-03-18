// файл MenuDestination.kt
package ci.nsu.mobile.main.ui.main

import ci.nsu.mobile.main.R

sealed class MenuDestination(val id: Int) {
    object Main : MenuDestination(R.id.menu_main)
    object Second : MenuDestination(R.id.menu_second)
}