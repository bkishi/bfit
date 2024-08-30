package uk.ac.bbk.bfit.Services;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Delete;
import androidx.room.OnConflictStrategy;

import uk.ac.bbk.bfit.Models.Workout;

public interface MainDAO {

    /**
     * Handle conflicts by replacing the workout entry if it already exists.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Workout workout);

    /**
     * Get all workouts from the database ordered by date.
     *
     * @return List of all workouts in the database.
     */
    @Query("SELECT * FROM workouts Order By date DESC")
    List<Workout> getAll();

    // TODO add logic to allow sort view by date or duration

//    @Query("SELECT * FROM workouts ORDER BY " +
//            "CASE WHEN :sortByDate = 1 THEN date END ASC, " +
//            "CASE WHEN :sortByDate = 0 THEN duration END ASC, " +
//            "CASE WHEN :sortByDate = 1 AND :ascending = 0 THEN date END DESC, " +
//            "CASE WHEN :sortByDate = 0 AND :ascending = 0 THEN duration END DESC")
//    List<Workout> getAll(boolean sortByDate, boolean ascending);

    /**
     * Get a workout by its ID.
     *
     * @param id ID of the workout to retrieve.
     * @return Workout with the specified ID.
     */
    @Query("SELECT * FROM workout WHERE id = :id")
    Workout getWorkoutById(int id);

    /**
     * Update a workout entry in the database.
     *
     * @param id ID of the workout to update.
     * @param title New title of the workout.
     * @param duration New duration of the workout.
     * @param date New date of the workout.
     */
    @Query("UPDATE workout SET title = :title, duration = :duration, date = :date WHERE id = :id")
    void update(int id, String title, int duration, long date);

    /**
     * Delete a workout entry from the database.
     *
     * @param workout Workout to delete.
     */
    @Delete
    void delete(Workout workout);

}
