package io.github.jamilelima.pomofocus.fragments


import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import io.github.jamilelima.pomofocus.adapters.TasksPendingAdapter
import io.github.jamilelima.pomofocus.AppDatabase

import io.github.jamilelima.pomofocus.R
import kotlinx.android.synthetic.main.fragment_tasks_pending.view.*


class TasksPendingFragment : Fragment() {

    private var tasksPendingRecyclerView: RecyclerView? = null
    private var tasksPendingAdapter: TasksPendingAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_tasks_pending, container, false)

        val db = Room.databaseBuilder(activity!!.applicationContext, AppDatabase::class.java, "production").allowMainThreadQueries().build()

        val tasksList = db.taskDao().undoneTasks

        tasksPendingRecyclerView = rootView.task_pending_recyclerview
        tasksPendingAdapter = TasksPendingAdapter(activity!!, tasksList)
        tasksPendingRecyclerView?.layoutManager = LinearLayoutManager(activity)
        tasksPendingRecyclerView?.adapter = tasksPendingAdapter

        return rootView
    }

}