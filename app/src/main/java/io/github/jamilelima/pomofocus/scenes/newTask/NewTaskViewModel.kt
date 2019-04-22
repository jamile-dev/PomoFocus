package io.github.jamilelima.pomofocus.scenes.newTask

data class NewTaskViewModel(var title: String,
                            var description: String,
                            var pomodoroAmount: Int,
                            var isCompleted: Boolean)