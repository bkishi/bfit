package uk.ac.bbk.bfit.Services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import uk.ac.bbk.bfit.Models.Workout;

@RunWith(AndroidJUnit4.class)
public class RoomDBTest {
    private RoomDB database;
    private MainDAO mainDAO;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        database = Room.inMemoryDatabaseBuilder(context, RoomDB.class).build();
        mainDAO = database.mainDAO();
    }

    @After
    public void closeDb() throws IOException {
        database.close();
    }

    @Test
    public void writeAndReadWorkout() throws Exception {
        Workout workout = new Workout();
        workout.setName("Test Workout");
        mainDAO.insert(workout);
        List<Workout> workouts = mainDAO.getAll();
        assertNotNull(workouts);
        assertEquals(workouts.get(0).getName(), "Test Workout");
    }
}