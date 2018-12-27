package io.github.jamilelima.pomofocus.Fragments;


import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import io.github.jamilelima.pomofocus.Adapters.TasksPendingAdapter;
import io.github.jamilelima.pomofocus.AppDatabase;
import io.github.jamilelima.pomofocus.Model.Task;

import io.github.jamilelima.pomofocus.R;
import java.util.List;


public class TasksPendingFragment extends Fragment {

  private RecyclerView tasksPendingRecyclerView;
  private TasksPendingAdapter tasksPendingAdapter;

  public TasksPendingFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_tasks_pending, container, false);

    AppDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(), AppDatabase.class, "production").allowMainThreadQueries().build();

    List<Task> tasksList = db.taskDao().getUndoneTasks();

    tasksPendingRecyclerView = rootView.findViewById(R.id.task_pending_recyclerview);
    tasksPendingAdapter = new TasksPendingAdapter(getActivity(), tasksList);
    tasksPendingRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    tasksPendingRecyclerView.setAdapter(tasksPendingAdapter);

    return rootView;
  }

}