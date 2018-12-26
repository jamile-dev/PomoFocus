package io.github.jamilelima.pomofocus;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.LinkedList;

public class TasksPendingAdapter extends RecyclerView.Adapter<TasksPendingAdapter.TasksPendingViewHolder> {

  private final LinkedList<String> mTaskPendingList;
  private LayoutInflater mInflater;

  public TasksPendingAdapter(Context context, LinkedList<String> taskPendingList) {
    mInflater = LayoutInflater.from(context);
    this.mTaskPendingList = taskPendingList;
  }

  @NonNull
  @Override
  public TasksPendingAdapter.TasksPendingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,
      int viewType) {
    View mItemView = mInflater.inflate(R.layout.list_item_task_pending, viewGroup, false);

    return new TasksPendingViewHolder(mItemView, this);
  }

  @Override
  public void onBindViewHolder(
      @NonNull TasksPendingAdapter.TasksPendingViewHolder tasksPendingViewHolder, int position) {
    String mCurrentPendingTask = mTaskPendingList.get(position);
    tasksPendingViewHolder.taskItemView.setText(mCurrentPendingTask);
  }

  @Override
  public int getItemCount() {
    return mTaskPendingList.size();
  }

  class TasksPendingViewHolder extends RecyclerView.ViewHolder {

    public final TextView taskItemView;
    final TasksPendingAdapter mAdapter;

    public TasksPendingViewHolder(View itemView, TasksPendingAdapter adapter) {
      super(itemView);
      taskItemView = itemView.findViewById(R.id.pending_tasks_item_title);
      this.mAdapter = adapter;
    }

  }
}
