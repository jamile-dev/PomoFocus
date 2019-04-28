package io.github.jamilelima.pomofocus.scenes.main

class MainPresenter(val view: Main.View) : Main.Presenter {

    override fun presentSelectedOption(selectedId: Int, howItWorksId: Int, settingsOptionsId: Int) {
        when (selectedId) {
            howItWorksId -> view.displayHowItWorksActivity()
            settingsOptionsId -> view.displaySettingsActivity()
        }
    }
}