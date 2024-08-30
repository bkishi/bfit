package uk.ac.bbk.bfit.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Entity class representing a workout entry in the Room database.
 * Contains the ID, title, duration, date, and evaluation of the workout.
 */
@Entity(tableName = "Workout")
public class Workout {

    /**
     * Autoincrement ID of the workouts.
     */
    @PrimaryKey(autoGenerate = true)
    private int id = 0;

    /**
     * Title of the workout.
     */
    @ColumnInfo(name = "title")
    private String title = "";

    /**
     * Duration of the workout in minutes.
     */
    @ColumnInfo(name = "duration")
    private int duration = 0;

    /**
     * Date in long to allow sort view.
     */
    //TODO logic display date in human readable format/convert to long
    //alt string, separate by / then sort by year, month, day
    @ColumnInfo(name = "date")
    private long date = 0;

    /**
     * A string containing a brief comment describing how well the workout went.
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