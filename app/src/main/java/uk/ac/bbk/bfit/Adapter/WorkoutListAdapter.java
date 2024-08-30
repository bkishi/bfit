package uk.ac.bbk.bfit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import uk.ac.bbk.bfit.Interface.WorkoutClickListener;
import uk.ac.bbk.bfit.Model.Workout;
import uk.ac.bbk.bfit.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        return new WorkoutViewHolder(LayoutInflater.from(context).inflate(R.layout.workoutList,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        holder.titleTxt.setText(workoutList.get(position).getTitle());
        holder.workoutTxt.setText(workoutList.get(position).getWorkout());
        holder.dateTxt.setText(workoutList.get(position).getDate());
        holder.dateTxt.setSelected(true);

        if (workoutList.get(position).getPinned() == true){
            holder.imageView.setImageResource(R.drawable.pin);
        }else {
            holder.imageView.setImageResource(0);
        }

        int color_code = getRandomColor();
        holder.cardView.setCardBackgroundColor(holder.itemView.getResources().getColor(color_code));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(workoutList.get(holder.getAdapterPosition()));
            }
        });

        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onLongPress(workoutList.get(holder.getAdapterPosition()),holder.cardView);
                return true;
            }
        });
    }

    private int getRandomColor(){
        List<Integer> colorCode = new ArrayList<>();
        colorCode.add(R.color.color1);
        colorCode.add(R.color.color2);
        colorCode.add(R.color.color3);
        colorCode.add(R.color.color4);
        colorCode.add(R.color.color5);
        colorCode.add(R.color.color6);
        colorCode.add(R.color.color7);
        colorCode.add(R.color.color8);
        colorCode.add(R.color.color9);

        Random random = new Random();
        int random_color = random.nextInt(colorCode.size());
        return colorCode.get(random_color);

    }

    @Override
    public int getItemCount() {
        return workoutList.size();
    }

    public void filterList(List<Workout> filterList){
        workoutList=filterList;
        notifyDataSetChanged();
    }
}


class WorkoutViewHolder extends RecyclerView.ViewHolder{
    CardView cardView;
    TextView workoutTxt,titleTxt,dateTxt;
    ImageView imageView;
    public WorkoutViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.note_container);
        workoutTxt = itemView.findViewById(R.id.workoutTxt);
        titleTxt = itemView.findViewById(R.id.titleTxt);
        dateTxt = itemView.findViewById(R.id.dateTxt);
        imageView = itemView.findViewById(R.id.pinned);
    }
}
