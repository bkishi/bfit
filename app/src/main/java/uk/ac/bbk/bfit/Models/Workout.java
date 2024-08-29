package uk.ac.bbk.bfit.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Entity class representing a workout entry in the Room database.
 *
 * <p>Core functionality:</p>
 * <ul>
 *   <li>Create workout entries</li>
 *   <ul>
 *     <li>Each workout entry must have:</li>
 *     <ul>
 *       <li>Title</li>
 *       <li>Duration</li>
 *       <li>Date of workout</li>
 *       <li>Exercise evaluation (a brief comment describing how well the workout went)</li>
 *     </ul>
 *   </ul>
 *   <li>View, edit, and manage workout entries within the app</li>
 *   <ul>
 *     <li>All workouts must be visible in a list within the app</li>
 *     <li>On workout click, user must be able to edit and delete the workout</li>
 *   </ul>
 *   <li>Store and retrieve workout entries locally</li>
 *   <ul>
 *     <li>Workouts must be saved locally in a Room database</li>
 *   </ul>
 * </ul>
 */
@Entity(tableName = "Workout")
public class Workout {

    /**
     * Autoincremented ID of the workouts.
     */
    @PrimaryKey(autoGenerate = true)
    private int id = 0;

    /**
     * Autoincremented ID of the workouts.
     */
    @ColumnInfo(name = "title")
    private String title = "";

    /**
     * Duration of the workout in minutes.
     */
    @ColumnInfo(name = "duration")
    iprivate nt duration = 0;

    /**
     * Autoincremented ID of the workouts.
     */
    @ColumnInfo(name = "date")
    private String date = "";

    /**
     * Autoincremented ID of the workouts.
     */
    @ColumnInfo(name = "evaluation")
    private String evaluation = "";

    /**
     * Gets the ID of the workout.
     *
     * @return the ID of the workout
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the workout.
     *
     * @param id the ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the title of the workout.
     *
     * @return the title of the workout
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the workout.
     *
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the duration of the workout.
     *
     * @return the duration of the workout
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the workout.
     *
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Gets the date of the workout.
     *
     * @return the date of the workout
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date of the workout.
     *
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets the evaluation of the workout.
     *
     * @return the evaluation of the workout
     */
    public String getEvaluation() {
        return evaluation;
    }

    /**
     * Sets the evaluation of the workout.
     *
     * @param evaluation the evaluation to set
     */
    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }
}