package io.github.jamilelima.pomofocus.scenes.main

class MainPresenter(val view: Main.View) : Main.Presenter {

    override fun presentSelectedOption(selectedId: Int, howItWorksId: Int, settingsOptionsId: Int): Boolean {
        if (selectedId == howItWorksId) view.displayHowItWorksActivity()

        if (selectedId == settingsOptionsId) view.displaySettingsActivity()
        return true
    }
}