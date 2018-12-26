package io.github.jamilelima.pomofocus;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Recycler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.LinkedList;


public class TasksPendingFragment extends Fragment {

  private final LinkedList<String> taskList = new LinkedList<>();
  private RecyclerView tasksPendingRecyclerView;
  private TasksPendingAdapter tasksPendingAdapter;

  public TasksPendingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_tasks_pending, container, false);

    this.addItemsToArray();

        tasksPendingRecyclerView = rootView.findViewById(R.id.task_pending_recyclerview);
        tasksPendingAdapter = new TasksPendingAdapter(getActivity(), taskList);
        tasksPendingRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        tasksPendingRecyclerView.setAdapter(tasksPendingAdapter);

         return rootView;
    }


    public void addItemsToArray() {
      for (int i = 0; i < 20 ; i++) {
        taskList.addLast("Make coffee " + i);
      }
    }

}
