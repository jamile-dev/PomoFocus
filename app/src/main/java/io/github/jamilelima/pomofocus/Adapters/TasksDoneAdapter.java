package io.github.jamilelima.pomofocus.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import io.github.jamilelima.pomofocus.Model.Task;
import io.github.jamilelima.pomofocus.R;
import java.util.List;

public class TasksDoneAdapter extends RecyclerView.Adapter<TasksDoneAdapter.TasksDoneViewHolder> {

  private List<Task> doneTasksList;
  private LayoutInflater mInflater;

  public TasksDoneAdapter(Context context, List<Task> tasksDoneList) {
    mInflater = LayoutInflater.from(context);
    this.doneTasksList = tasksDoneList;
  }

  @NonNull
  @Override
  public TasksDoneViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

    View itemView = mInflater.inflate(R.layout.list_item_task_done, viewGroup, false);
    return new TasksDoneViewHolder(itemView, this);
  }

  @Override
  public void onBindViewHolder(@NonNull TasksDoneViewHolder tasksDoneViewHolder, int position) {
    Task currentDoneTask = doneTasksList.get(position);
    tasksDoneViewHolder.taskTitle.setText(currentDoneTask.getTitle());
  }

  @Override
  public int getItemCount() {
    return doneTasksList.size();
  }


  class TasksDoneViewHolder extends RecyclerView.ViewHolder {

    final TasksDoneAdapter mAdapter;
    public final TextView taskTitle;

    public TasksDoneViewHolder(View itemView, TasksDoneAdapter adapter) {
      super(itemView);
      taskTitle = itemView.findViewById(R.id.done_tasks_item_title);

      this.mAdapter = adapter;
    }

  }

}
