package io.github.jamilelima.pomofocus.scenes.main

import android.view.MenuItem

class Main {

    interface View {
        fun onOptionsItemSelected(item: MenuItem): Boolean
        fun displaySettingsActivity()
        fun displayHowItWorksActivity()
    }

    interface Presenter {
        fun presentSelectedOption(selectedId: Int, settingsId: Int, howItWorksId: Int): Boolean
    }

}