package uk.ac.bbk.bfit.Services;

import uk.ac.bbk.bfit.Models.Workout;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

/**
 * RoomDb is the main database class for the BFit application.
 * It provides an instance of the Room database and the DAO to access the database.
 */

@Database(entities = Workout.class, version = 2, exportSchema = false)
public abstract class RoomDb extends RoomDatabase {

    /**
     * The singleton instance of the RoomDb.
     */
    private static RoomDb database;
    /**
     * The name of the database.
     */
    private static final String DATABASE_NAME = "BFit";

    /**
     * If the RoomDB instance is null, initializes database.
     *
     * @param context The application context.
     * @return The singleton instance of the RoomDb.
     */
    public static synchronized RoomDb getInstance(final Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDb.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }

    /**
     * Provides the DAO to access the database.
     *
     * @return The MainDAO instance.
     */
    public abstract MainDAO mainDAO();
}
