// RoomDbTest.java
package uk.ac.bbk.bfit.Services;

import uk.ac.bbk.bfit.Models.Workout;
import uk.ac.bbk.bfit.DAO.MainDAO;

import android.content.Context;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(AndroidJUnit4.class)
public class RoomDbTest {

    private RoomDb database;
    private MainDAO mainDAO;

    @BeforeEach
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        database = Room.inMemoryDatabaseBuilder(context, RoomDb.class)
                .allowMainThre