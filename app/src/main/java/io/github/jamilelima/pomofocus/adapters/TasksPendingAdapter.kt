package io.github.jamilelima.pomofocus.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import io.github.jamilelima.pomofocus.activities.PomodoroTimerActivity
import io.github.jamilelima.pomofocus.Model.Task
import io.github.jamilelima.pomofocus.R
import kotlinx.android.synthetic.main.list_item_task_pending.view.*

class TasksPendingAdapter(context: Context, private val mTaskPendingList: List<Task>) : RecyclerView.Adapter<TasksPendingAdapter.TasksPendingViewHolder>() {
    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var taskName: String? = null
    private var taskId: Int = 0
    private lateinit var pomodoroActivity: Intent

    override fun onCreateViewHolder(viewGroup: ViewGroup,
                                    viewType: Int): TasksPendingViewHolder {
        val mItemView = mInflater.inflate(R.layout.list_item_task_pending, viewGroup, false)

        val timerIcon: ImageView
        val taskNameView: TextView
        timerIcon = mItemView.pending_tasks_item_goTimer
        taskNameView = mItemView.pending_tasks_item_title

        timerIcon.setOnClickListener {
            pomodoroActivity = Intent(viewGroup.context, PomodoroTimerActivity::class.java)
            taskName = taskNameView.text as String
            pomodoroActivity.putExtra("EXTRA_TASK_NAME", taskName)
            pomodoroActivity.putExtra("EXTRA_TASK_ID", taskId)
            viewGroup.context.startActivity(pomodoroActivity)
        }

        return TasksPendingViewHolder(mItemView)
    }

    override fun onBindViewHolder(
            tasksPendingViewHolder: TasksPendingViewHolder, position: Int) {
        val mCurrentPendingTask = mTaskPendingList[position]
        tasksPendingViewHolder.taskTitle.text = mCurrentPendingTask.title
        tasksPendingViewHolder.taskDescription.text = mCurrentPendingTask.description

        taskId = mCurrentPendingTask.id
    }

    override fun getItemCount(): Int {
        return mTaskPendingList.size
    }

    inner class TasksPendingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskTitle: TextView = itemView.pending_tasks_item_title
        val taskDescription: TextView = itemView.pending_tasks_item_description
    }
}
