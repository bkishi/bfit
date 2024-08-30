package uk.ac.bbk.bfit.Interface;

import uk.ac.bbk.bfit.Models.Workout;
import androidx.cardview.widget.CardView;

/**
 * Interface definition for a callback to be invoked when a workout itemis clicked or long-pressed.
 */
public interface WorkoutClickListener {

    /**
     * Called when a workout item has been clicked.
     *
     * @param workout The workout that was clicked.
     */
    void onClick(Workout workout);

    /**
     * Called when a workout item has been long-pressed.
     *
     * @param workout The workout that was long-pressed.
     * @param cardView The CardView that was long-pressed.
     */
    void onLongClick(Workout workout, CardView cardView);
}
