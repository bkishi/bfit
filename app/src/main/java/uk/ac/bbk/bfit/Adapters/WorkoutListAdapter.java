package uk.ac.bbk.bfit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import uk.ac.bbk.bfit.Interface.WorkoutClickListener;
import uk.ac.bbk.bfit.Models.Workout;
import uk.ac.bbk.bfit.R;

import java.util.List;

public class WorkoutListAdapter extends RecyclerView.Adapter<WorkoutViewHolder> {
    Context context;
    List<Workout> workoutList;
    WorkoutClickListener listener;

    public WorkoutListAdapter(Context context, List<Workout> workoutList, WorkoutClickListener listener) {
        this.context = context;
        this.workoutList = workoutList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WorkoutViewHolder(LayoutInflater.from(context).inflate(R.layout.workout_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        holder.titleTxt.setText(workoutList.get(position).getTitle());
        holder.durationTxt.setText(workoutList.get(position).getDuration());
        holder.dateTxt.setText(workoutList.get(position).getDate());
        holder.dateTxt.setSelected(true);

        holder.workout_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(workoutList.get(holder.getAdapterPosition()));
            }
        });


        holder.workout_container.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onLongClick(workoutList.get(holder.getAdapterPosition()), holder.workout_container);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return workoutList.size();
    }

    public void filterList(List<Workout> filterList) {
        workoutList = filterList;
        notifyDataSetChanged();
    }
}

class WorkoutViewHolder extends RecyclerView.ViewHolder {
    CardView workout_container;
    TextView titleTxt, durationTxt, dateTxt;

    public WorkoutViewHolder(@NonNull View itemView) {
        super(itemView);
        workout_container = itemView.findViewById(R.id.workout_container);
        titleTxt = itemView.findViewById(R.id.titleTxt);
        durationTxt = itemView.findViewById(R.id.durationTxt);
        dateTxt = itemView.findViewById(R.id.dateTxt);
    }
}