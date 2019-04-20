package io.github.jamilelima.pomofocus

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

import io.github.jamilelima.pomofocus.model.Task

@Dao
interface TaskDao {

    @get:Query("SELECT * FROM task WHERE is_completed LIKE 1")
    val doneTasks: List<Task>

    @get:Query("SELECT * FROM task WHERE is_completed LIKE 0")
    val undoneTasks: List<Task>

    @Insert
    fun insertAll(vararg task: Task)

    @Query("UPDATE task SET is_completed  = :isCompleted WHERE id = :id")
    fun setCompleted(isCompleted: Boolean, id: Int)

    @Query("SELECT pomodoro_amount FROM task WHERE id = :id")
    fun getPomodoroAmount(id: Int): Int

    @Query("UPDATE task SET pomodoro_amount = :pomodoroAmount WHERE id = :id")
    fun setPomodoroAmount(pomodoroAmount: Int, id: Int)

}