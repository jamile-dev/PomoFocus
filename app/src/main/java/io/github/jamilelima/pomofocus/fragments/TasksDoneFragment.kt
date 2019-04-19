package io.github.jamilelima.pomofocus.fragments


import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.jamilelima.pomofocus.adapters.TasksDoneAdapter
import io.github.jamilelima.pomofocus.AppDatabase
import io.github.jamilelima.pomofocus.R
import kotlinx.android.synthetic.main.fragment_tasks_done.view.*


class TasksDoneFragment : Fragment() {

    private var tasksDoneRecyclerView: RecyclerView? = null
    private var tasksDoneAdapter: TasksDoneAdapter? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_tasks_done, container, false)

        val db = Room
                .databaseBuilder(activity!!.applicationContext, AppDatabase::class.java, "production").allowMainThreadQueries().build()

        val tasksList = db.taskDao().doneTasks

        tasksDoneRecyclerView = rootView.task_done_recyclerview
        tasksDoneAdapter = TasksDoneAdapter(activity!!, tasksList)
        tasksDoneRecyclerView?.layoutManager = LinearLayoutManager(activity)
        tasksDoneRecyclerView?.adapter = tasksDoneAdapter

        return rootView
    }

}
