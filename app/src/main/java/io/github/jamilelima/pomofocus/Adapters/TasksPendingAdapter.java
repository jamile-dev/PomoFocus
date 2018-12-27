package io.github.jamilelima.pomofocus.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.jamilelima.pomofocus.Activities.PomodoroTimerActivity;
import io.github.jamilelima.pomofocus.Model.Task;
import io.github.jamilelima.pomofocus.R;
import java.util.List;

public class TasksPendingAdapter extends RecyclerView.Adapter<TasksPendingAdapter.TasksPendingViewHolder> {

  private List<Task> mTaskPendingList;
  private LayoutInflater mInflater;
  String taskName;
  int taskId;
  Intent pomodoroActivity;

  public TasksPendingAdapter(Context context, List<Task> taskPendingList) {
    mInflater = LayoutInflater.from(context);
    this.mTaskPendingList = taskPendingList;
  }

  @NonNull
  @Override
  public TasksPendingAdapter.TasksPendingViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup,
      int viewType) {
    View mItemView = mInflater.inflate(R.layout.list_item_task_pending, viewGroup, false);

    final ImageView timerIcon;
    final TextView taskNameView;
    timerIcon = mItemView.findViewById(R.id.pending_tasks_item_goTimer);
    taskNameView = mItemView.findViewById(R.id.pending_tasks_item_title);

    timerIcon.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        pomodoroActivity= new Intent(viewGroup.getContext(), PomodoroTimerActivity.class);
        taskName = (String) taskNameView.getText();
        pomodoroActivity.putExtra("EXTRA_TASK_NAME", taskName);
        pomodoroActivity.putExtra("EXTRA_TASK_ID", taskId);
        viewGroup.getContext().startActivity(pomodoroActivity);
      }
    });

    return new TasksPendingViewHolder(mItemView, this);
  }

  @Override
  public void onBindViewHolder(
      @NonNull TasksPendingAdapter.TasksPendingViewHolder tasksPendingViewHolder, int position) {
    Task mCurrentPendingTask = mTaskPendingList.get(position);
    tasksPendingViewHolder.taskTitle.setText(mCurrentPendingTask.getTitle());
    taskId = mCurrentPendingTask.getId();
  }

  @Override
  public int getItemCount() {
    return mTaskPendingList.size();
  }

  class TasksPendingViewHolder extends RecyclerView.ViewHolder {

    public final TextView taskTitle;
    public final TextView taskDescription;
    final TasksPendingAdapter mAdapter;

    public TasksPendingViewHolder(View itemView, TasksPendingAdapter adapter) {
      super(itemView);
      taskTitle = itemView.findViewById(R.id.pending_tasks_item_title);
      taskDescription = itemView.findViewById(R.id.task_description);

      this.mAdapter = adapter;
    }

  }
}
