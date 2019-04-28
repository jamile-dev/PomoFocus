package io.github.jamilelima.pomofocus.scenes.main

class Main {

    interface View {
        fun displaySettingsActivity()
        fun displayHowItWorksActivity()
    }

    interface Presenter {
        fun presentSelectedOption(selectedId: Int, settingsId: Int, howItWorksId: Int)
    }

}