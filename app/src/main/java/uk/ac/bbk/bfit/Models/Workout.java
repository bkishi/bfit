package uk.ac.bbk.bfit.Models;

import android.room.ColumnInfo;
import android.room.Entity;
import android.room.PrimaryKey;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import java.io.serializable;


/**
 * Entity class representing a workout entry in the Room database.
 *
 * Core functionality:
 * a) Create workout entries;
 * i) Each workout entry must have
 * (1) Title
 * (2) Duration
 * (3) Date of workout
 * (4) Your exercise evaluation. (Which is a brief comment
 * describing how well the workout went.)
 * b) View, edit, and manage workout entries within the app;
 * i) All workouts must be visible in a list within the app
 * ii) On workout click, user must be able to edit and delete the workout
 * c) Store and retrieve workout entries locally
 * i) Workouts must be saved locally in a Room database
 *
 *
 *
 *
 */

@Entity(tableName = "Workout")
public class Workout {
    @PrimaryKey(autoGenerate = true)
    int id = 0;

    @ColumnInfo(name = "title")
    String title = "";

    @ColumnInfo(name = "duration")
    String duration = "";

    @ColumnInfo(name = "date")
    String date = "";

    @ColumnInfo(name = "evaluation")
    String evaluation = "";

// extended functionality
//    @ColumnInfo(name = "target")
//    Int target = 0;
//
//    @ColumnInfo(name = "category")
//    String category = "";


    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    // Constructor















}
