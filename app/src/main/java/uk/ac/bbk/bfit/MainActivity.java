package uk.ac.bbk.bfit;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.os.Bundle;
import android.widget.TextView;

import uk.ac.bbk.bfit.Adapters.WorkoutListAdapter;
import uk.ac.bbk.bfit.Interface.WorkoutClickListener;
import uk.ac.bbk.bfit.Models.Workout;
import uk.ac.bbk.bfit.Services.RoomDB;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    WorkoutListAdapter workoutListAdapter;
    List<Workout> workoutList = new ArrayList<>();
    RoomDB database;
    Button add_workout;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_home);
        add_workout = findViewById(R.id.add_workout);

        database = RoomDB.getInstance(this);
        workoutList = database.mainDAO().getAll();

        updateRecycler(workoutList);

        add_workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the action for the add_workout button
            }
        });
    }

    private void updateRecycler(List<Workout> workoutList) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        workoutListAdapter = new WorkoutListAdapter(MainActivity.this, workoutList, workoutClickListener);
        recyclerView.setAdapter(workoutListAdapter);
    }

    private final WorkoutClickListener workoutClickListener = new WorkoutClickListener() {
        @Override
        public void onClick(Workout workout) {
            // Define the action for the workout click
        }

        @Override
        public void onLongClick(Workout workout, CardView cardView) {
            // Define the action for the workout long click
        }
    };
}