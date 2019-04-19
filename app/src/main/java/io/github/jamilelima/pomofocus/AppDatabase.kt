package io.github.jamilelima.pomofocus


import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import io.github.jamilelima.pomofocus.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
