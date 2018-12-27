package io.github.jamilelima.pomofocus.Fragments;


import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.github.jamilelima.pomofocus.Adapters.TasksDoneAdapter;
import io.github.jamilelima.pomofocus.Adapters.TasksPendingAdapter;
import io.github.jamilelima.pomofocus.AppDatabase;
import io.github.jamilelima.pomofocus.Model.Task;
import io.github.jamilelima.pomofocus.R;
import java.util.List;


public class TasksDoneFragment extends Fragment {

    private RecyclerView tasksDoneRecyclerView;
    private TasksDoneAdapter tasksDoneAdapter;


    public TasksDoneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootView = inflater.inflate(R.layout.fragment_tasks_done, container, false);

        AppDatabase db = Room
            .databaseBuilder(getActivity().getApplicationContext(), AppDatabase.class, "production").allowMainThreadQueries().build();

        List<Task> tasksList = db.taskDao().getDoneTasks();

        tasksDoneRecyclerView = rootView.findViewById(R.id.task_done_recyclerview);
        tasksDoneAdapter = new TasksDoneAdapter(getActivity(), tasksList);
        tasksDoneRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        tasksDoneRecyclerView.setAdapter(tasksDoneAdapter);

       return rootView;
    }

}
