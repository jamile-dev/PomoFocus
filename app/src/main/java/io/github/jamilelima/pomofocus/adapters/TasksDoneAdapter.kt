package io.github.jamilelima.pomofocus.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.github.jamilelima.pomofocus.Model.Task
import io.github.jamilelima.pomofocus.R
import kotlinx.android.synthetic.main.list_item_task_done.view.*

class TasksDoneAdapter(context: Context, private val doneTasksList: List<Task>) : RecyclerView.Adapter<TasksDoneAdapter.TasksDoneViewHolder>() {
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(
            viewGroup: ViewGroup,
            viewType: Int
    ): TasksDoneViewHolder {

        val itemView = mInflater.inflate(R.layout.list_item_task_done, viewGroup, false)
        return TasksDoneViewHolder(itemView)
    }

    override fun onBindViewHolder(tasksDoneViewHolder: TasksDoneViewHolder, position: Int) {
        val currentDoneTask = doneTasksList[position]
        tasksDoneViewHolder.taskTitle.text = currentDoneTask.title
        tasksDoneViewHolder.taskDescription.text = currentDoneTask.description
    }

    override fun getItemCount(): Int {
        return doneTasksList.size
    }

    inner class TasksDoneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskTitle: TextView = itemView.done_tasks_item_title
        val taskDescription: TextView = itemView.done_tasks_item_description
    }
}
